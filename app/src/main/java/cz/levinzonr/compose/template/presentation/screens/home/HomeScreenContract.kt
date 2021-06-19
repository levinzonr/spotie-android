package cz.levinzonr.compose.template.presentation.screens.home

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState

data class State(
    val isLoading: Boolean = false,
    val data: String? = null
) : BaseState

sealed class Change : BaseChange {
    object IncreaseCounter : Change()
    object DataLoadingStart : Change()
    object DataLoaded : Change()
}

sealed class Action : BaseAction {
    object IncreaseButtonClick : Action()
    object Init : Action()
}
