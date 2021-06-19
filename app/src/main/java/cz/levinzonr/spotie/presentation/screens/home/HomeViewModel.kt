package cz.levinzonr.spotie.presentation.screens.home

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetModelUseCase
import cz.levinzonr.spotie.domain.usecases.GetUserUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : RoxieViewModel<Action, State, Change>() {

    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.DataLoadingStart -> state.copy(isLoading = true)
            is Change.DataLoaded -> state.copy(isLoading = false, user = change.user)
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            is Action.Init -> bindInitAction(action)
        }
    }


    private fun bindInitAction(init: Action.Init): Flow<Change> = flow {
        emit(Change.DataLoadingStart)
        getUserUseCase.getUser()
            .ifSuccess { emit(Change.DataLoaded(it)) }
            .ifError { Timber.e(it) }
    }
}
