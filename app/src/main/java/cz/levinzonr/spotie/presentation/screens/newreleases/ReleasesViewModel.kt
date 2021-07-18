package cz.levinzonr.spotie.presentation.screens.newreleases

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetNewlyReleasedAlbumsUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ReleasesViewModel @Inject constructor(
    private val getNewReleasesUseCase: GetNewlyReleasedAlbumsUseCase
) : RoxieViewModel<Action, State, Change>() {

    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.Loaded -> state.copy(albums = change.data)
            is Change.Loading -> state
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            Action.Init -> action.bind()
        }.flowOn(Dispatchers.IO)
    }

    private fun Action.bind(): Flow<Change> = flow {
        getNewReleasesUseCase.getNewReleases()
            .ifError { Timber.e(it) }
            .ifSuccess { emit(Change.Loaded(it)) }
    }

}
