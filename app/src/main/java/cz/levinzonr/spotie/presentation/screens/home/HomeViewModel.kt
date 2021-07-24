package cz.levinzonr.spotie.presentation.screens.home

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetNewlyReleasesUseCase
import cz.levinzonr.spotie.domain.usecases.GetTopTracksUseCase
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
class HomeViewModel @Inject constructor(
    private val getTopTracksUseCase: GetTopTracksUseCase,
    private val getNewlyReleasesUseCase: GetNewlyReleasesUseCase
)  : RoxieViewModel<Action, State, Change>(){

    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when(change) {
            Change.LoadingStarted -> state
            is Change.NewReleasedLoaded -> state.copy(releases = change.releases)
            is Change.TopTracksLoaded -> state.copy(topTracks = change.data)
        }
    }


    init {
        startActionsObserver()
        dispatch(Action.Init)
    }


    override fun emitAction(action: Action): Flow<Change> {
       return when(action) {
           Action.Init -> flow {
               emit(Change.LoadingStarted)
               getNewlyReleasesUseCase.getNewReleases()
                   .ifSuccess { emit(Change.NewReleasedLoaded(it)) }
                   .ifError { Timber.e(it) }

               getTopTracksUseCase.getTopTracks()
                   .ifSuccess { emit(Change.TopTracksLoaded(it)) }
                   .ifError { Timber.e(it) }
           }
       }.flowOn(Dispatchers.IO)
    }




}