package cz.levinzonr.spotie.data.manager

import android.content.Context
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.PlayerApi
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.protocol.client.CallResult
import cz.levinzonr.spotie.data.mappers.SpotifyTrackResponseMapper
import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.models.PlayerState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SpotifyPlayerManager @Inject constructor(
    private val context: Context,
    private val params: ConnectionParams
) : PlayerManager {

    private var remote: SpotifyAppRemote? = null
    private val stateFlow = MutableStateFlow<PlayerState>(PlayerState.Idle)

    override val playerStateFlow: Flow<PlayerState>
        get() = stateFlow

    init {
        connect()
    }

    private fun withPlayerApi(block: PlayerApi.() -> CallResult<*>) {
        remote?.playerApi?.run(block)?.awaitAndValidate()
    }

    override fun connect() {
        SpotifyAppRemote.connect(context, params, object : Connector.ConnectionListener {
            override fun onConnected(spotifyAppRemote: SpotifyAppRemote?) {
                remote = spotifyAppRemote
                remote?.let { init(it.playerApi) }
            }

            override fun onFailure(error: Throwable?) {
                stateFlow.tryEmit(PlayerState.Error(error ?: Throwable()))
            }
        })
    }

    override fun disconnect() {
        remote?.let(SpotifyAppRemote::disconnect)
    }

    private fun init(playerApi: PlayerApi) {
        playerApi.stateFlow().mapNotNull {
            val track =
                it.track?.let(SpotifyTrackResponseMapper::toDomain) ?: return@mapNotNull null
            PlayerState.Ready(track, !it.isPaused)
        }.onEach { stateFlow.emit(it) }
            .catch { stateFlow.emit(PlayerState.Error(it)) }
            .launchIn(GlobalScope)
    }


    override suspend fun play(trackId: String) {
        withPlayerApi {
            val state = playerState.await().data
            when {
                state.isPaused && state.track.uri == trackId -> resume()
                !state.isPaused && state.track.uri == trackId -> pause()
                else -> play(trackId)
            }
        }
    }

    override suspend fun next() {
        withPlayerApi { skipNext() }
    }

    override suspend fun pause() {
        withPlayerApi { pause() }
    }

    override suspend fun toggle() {
        withPlayerApi {
            if (playerState.await().data.isPaused) {
                resume()
            } else {
                pause()
            }
        }
    }

    override suspend fun previous() {
        withPlayerApi { skipPrevious() }
    }

    override suspend fun addToQueue(trackId: String) {
        addToQueue(trackId)
    }

    override suspend fun shuffle(shuffle: Boolean) {
        withPlayerApi { setShuffle(shuffle) }
    }


}