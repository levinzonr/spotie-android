package cz.levinzonr.spotie.presentation.screens.home

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetModelUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getModelUseCase: GetModelUseCase
) : RoxieViewModel<Action, State, Change>() {

    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.DataLoadingStart -> state.copy(isLoading = true)
            is Change.DataLoaded -> state.copy(isLoading = false)
            is Change.IncreaseCounter -> state
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            is Action.Init -> bindInitAction(action)
            is Action.IncreaseButtonClick -> bindCounterIncreaseAction(action)
        }
    }

    private fun bindCounterIncreaseAction(action: Action.IncreaseButtonClick): Flow<Change> = flow {
    }

    private fun bindInitAction(init: Action.Init): Flow<Change> = flow {
        emit(Change.DataLoadingStart)
        getModelUseCase.get()
            .ifSuccess { emit(Change.DataLoaded) }
            .ifError { emit(Change.DataLoaded) }
        emit(Change.DataLoaded)
    }
}
