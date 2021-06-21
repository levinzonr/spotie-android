package cz.levinzonr.spotie.presentation.screens.home

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.User

data class State(
    val isLoading: Boolean = false,
    val user: User? = null
) : BaseState

sealed class Change : BaseChange {
    object DataLoadingStart : Change()
    data class DataLoaded(val user: User) : Change()
}

sealed class Action : BaseAction {
    object Init : Action()
}
