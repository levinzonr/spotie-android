package cz.levinzonr.spotie.presentation.screens.trackdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.data.manager.SpotifyPlayerManager
import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.models.PlayerState
import cz.levinzonr.spotie.domain.usecases.GetTrackDetailsUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import cz.levinzonr.spotie.domain.usecases.player.PlayTrackUseCase
import cz.levinzonr.spotie.domain.usecases.player.PlayerStateUseCase
import cz.levinzonr.spotie.presentation.screens.trackdetails.args.TrackDetailsRouteArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TrackDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getTrackDetailsUseCase: GetTrackDetailsUseCase,
    private val getPlayerStateUseCase: PlayerStateUseCase,
    private val playTrackUseCase: PlayTrackUseCase
) : RoxieViewModel<Action, State, Change>() {

    private val trackId = TrackDetailsRouteArgs.fromSavedStatedHandle(savedStateHandle).trackId

    override val initialState: State = State.Idle

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.LoadStarted -> State.Loading
            is Change.Loaded -> State.Loaded(change.track, false).also { initPlaybackSubscribtion() }
            is Change.TrackPlaybackStateChanged -> {
                if (state is State.Loaded) {
                    state.copy(isPlaying = change.isPlaying)
                } else {
                    state
                }
            }
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init(trackId))
    }

    private fun initPlaybackSubscribtion() {
        getPlayerStateUseCase.getPlayerState()
            .mapNotNull { it as? PlayerState.Ready }
            .onEach { dispatch(Action.ActiveTrackChanged(it.track.id, it.isPlaying)) }
            .launchIn(viewModelScope)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            is Action.Init -> action.bind()
            is Action.ActiveTrackChanged -> action.bind()
            is Action.TogglePlaybackPressed -> action.bind().flowOn(Dispatchers.IO)
        }
    }

    private fun Action.ActiveTrackChanged.bind() : Flow<Change> = flow {
        emit(Change.TrackPlaybackStateChanged(trackId == id && isPlaying))
    }

    private fun Action.Init.bind(): Flow<Change> = flow {
        emit(Change.LoadStarted)
        getTrackDetailsUseCase.getTrackDetails(id)
            .ifSuccess { emit(Change.Loaded(it)) }
            .ifError { Timber.e(it) }
    }


    private fun Action.TogglePlaybackPressed.bind(): Flow<Change> = flow {
        playTrackUseCase.play(trackId)
    }
}

