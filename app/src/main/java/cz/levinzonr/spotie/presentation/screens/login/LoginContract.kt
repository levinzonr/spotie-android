package cz.levinzonr.spotie.presentation.screens.login

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState

class State() : BaseState

sealed interface Change : BaseChange {
    object LoginStarted : Change
    object LoginFinished : Change
}

sealed interface Action : BaseAction {
    object LoginClicked : Action
}