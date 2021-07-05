package cz.levinzonr.spotie.presentation.screens.trackdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetTrackDetailsUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import cz.levinzonr.spotie.presentation.screens.trackdetails.args.TrackDetailsRouteArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TrackDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getTrackDetailsUseCase: GetTrackDetailsUseCase
) : RoxieViewModel<Action, State, Change>() {


    override val initialState: State = State.Idle

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.LoadStarted -> State.Loading
            is Change.Loaded -> State.Loaded(change.track)
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init(TrackDetailsRouteArgs.fromSavedStatedHandle(savedStateHandle).trackId))
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when(action) {
            is Action.Init -> action.bind()
        }
    }


    private fun Action.Init.bind() : Flow<Change> = flow {
        emit(Change.LoadStarted)
        getTrackDetailsUseCase.getTrackDetails(id)
            .ifSuccess { emit(Change.Loaded(it)) }
            .ifError { Timber.e(it) }
    }

}
