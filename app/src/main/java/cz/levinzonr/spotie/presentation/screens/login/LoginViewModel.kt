package cz.levinzonr.spotie.presentation.screens.login

import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.models.SpotifyCredentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val spotifyCredentials: SpotifyCredentials
) : RoxieViewModel<Action, State, Change>() {

    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        state
    }

    init {
        startActionsObserver()
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when(action) {
            is Action.LoginClicked -> bindLoginAction()
        }
    }

    private fun bindLoginAction() : Flow<Change> = flow {

    }
}