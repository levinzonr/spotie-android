package cz.levinzonr.spotie.presentation.screens

import android.content.Intent
import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState

data class State(
    val isLoggedIn: Boolean = false
) : BaseState

sealed interface Change : BaseChange {
    object LoginStarted : Change
    object LoginFinished : Change
    object LoginFailed : Change
}

sealed interface Action : BaseAction {
    object Init : Action
    data class HandleLoginResult(val code: Int, val intent: Intent?) : Action
}
