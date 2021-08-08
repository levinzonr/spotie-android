package cz.levinzonr.spotie.presentation.screens.playlists

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.usecases.GetMyPlaylistsUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PlaylistsViewModel @Inject constructor(
    private val getMyPlaylistsUseCase: GetMyPlaylistsUseCase
) : RoxieViewModel<Action, State, Change>() {
    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when (change) {
            is Change.PlaylistsLoaded -> state.copy(
                playlists = change.data,
                isLoading = false,
            )
            is Change.QueryChanged -> state.copy(
                searchQuery = change.query
            )
            is Change.LoadStarted -> {
                state.copy(isLoading = true)
            }
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            Action.Init -> bindInitAction()
            is Action.QueryChange -> bindQueryChangeAction(action.query)
        }
    }

    private fun bindInitAction() = flow<Change> {
        emit(Change.LoadStarted)
        getMyPlaylistsUseCase.getPlaylists()
            .ifSuccess { emit(Change.PlaylistsLoaded(it)) }
            .ifError { Timber.e(it) }
    }

    private fun bindQueryChangeAction(query: String): Flow<Change> {
        return flow {
            emit(Change.QueryChanged(query))
            getMyPlaylistsUseCase.getPlaylists(query)
                .ifSuccess { emit(Change.PlaylistsLoaded(it)) }
        }
    }
}