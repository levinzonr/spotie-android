package cz.levinzonr.spotie.data.manager

import android.content.Context
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.PlayerApi
import com.spotify.android.appremote.api.SpotifyAppRemote
import cz.levinzonr.spotie.data.mappers.SpotifyTrackResponseMapper
import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.models.PlayerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class SpotifyPlayerManager @Inject constructor(
    private val context: Context,
    private val params: ConnectionParams
) : PlayerManager, Connector.ConnectionListener {

    private var remote: SpotifyAppRemote? = null
    private val stateFlow = MutableStateFlow<PlayerState>(PlayerState.Idle)

    override val playerStateFlow: Flow<PlayerState>
        get() = stateFlow

    init {
        connect()
    }

    override fun onConnected(spotifyAppRemote: SpotifyAppRemote?) {
        Timber.d("on connected: ${spotifyAppRemote != null}")
        spotifyAppRemote?.let {
            remote = it
            init(it.playerApi)
        }
    }

    override fun connect() {
        SpotifyAppRemote.connect(context, params, this)
    }

    override fun disconnect() {
    }

    private fun init(playerApi: PlayerApi) {


        playerApi.stateFlow().mapNotNull {
            val track = it.track?.let(SpotifyTrackResponseMapper::toDomain) ?: return@mapNotNull null
            PlayerState.Ready(track, !it.isPaused)
        }.onEach { stateFlow.emit(it) }
            .catch { stateFlow.emit(PlayerState.Error(it)) }
            .launchIn(GlobalScope)
    }


    override fun onFailure(error: Throwable?) {
        Timber.d("Error: $error")
    }

    override suspend fun play(trackId: String) {

    }

    override suspend fun next() {
    }

    override suspend fun pause() {
    }

    override suspend fun toggle() {
    }

    override suspend fun previous() {
    }

    override suspend fun addToQueue(trackId: String) {
    }

    override suspend fun shuffle(shuffle: Boolean) {
    }

    private fun PlayerApi.stateFlow(): Flow<com.spotify.protocol.types.PlayerState> = callbackFlow {
        subscribeToPlayerState().setEventCallback {
           trySend(it)
        }

        subscribeToPlayerState().setErrorCallback {
            throw it
        }

        awaitClose {
            Timber.d("Close")
        }
    }
}