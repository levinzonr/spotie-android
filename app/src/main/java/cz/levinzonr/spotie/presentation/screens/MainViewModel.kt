package cz.levinzonr.spotie.presentation.screens

import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationResponse
import cz.levinzonr.roxie.RoxieViewModel
import cz.levinzonr.spotie.domain.manager.UserManager
import cz.levinzonr.spotie.domain.usecases.LoginUseCase
import cz.levinzonr.spotie.domain.usecases.ifError
import cz.levinzonr.spotie.domain.usecases.ifSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userManager: UserManager,
    private val loginUseCase: LoginUseCase
) : RoxieViewModel<Action, State, Change>() {

    override val initialState: State = State()

    override val reducer: suspend (state: State, change: Change) -> State = { state, change ->
        when(change) {
            Change.LoginFailed -> state
            Change.LoginFinished -> state.copy(isLoggedIn = true)
            else -> state
        }
    }

    init {
        startActionsObserver()
        dispatch(Action.Init)
    }

    override fun emitAction(action: Action): Flow<Change> {
        return when (action) {
            is Action.Init -> bindInitAction(action)
            is Action.HandleLoginResult -> handleLoginResult(action)
        }
    }

    private fun bindInitAction(action: Action.Init) = flow<Change> {
        if (userManager.isLoggedIn()) emit(Change.LoginFinished)
    }

    private fun handleLoginResult(action: Action.HandleLoginResult) = flow<Change> {
        val result = AuthorizationClient.getResponse(action.code, action.intent)
        when (result.type) {
            AuthorizationResponse.Type.CODE -> {
                loginUseCase.login(result.code)
                    .ifError { emit(Change.LoginFailed) }
                    .ifSuccess { emit(Change.LoginFinished) }
            }
            else -> {
                emit(Change.LoginFailed)
            }
        }
    }

}