package cz.levinzonr.spotie.presentation.screens.toptracks

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetTopTracksUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TopTracksViewModel @Inject constructor(
    private val getTopTracksUseCase: GetTopTracksUseCase
) : RoxieViewModel<Action, State, Change>() {

    override val initialState: State = State.Idle

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.LoadingFinished -> State.ShowContent(change.topTracks)
            Change.LoadingStarted -> State.Loading
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            is Action.Init -> bindInitAction()
        }
    }

    private fun bindInitAction() = flow {
        emit(Change.LoadingStarted)
        getTopTracksUseCase.getTopTracks()
            .ifError { Timber.e(it) }
            .ifSuccess { emit(Change.LoadingFinished(it)) }
    }
}
