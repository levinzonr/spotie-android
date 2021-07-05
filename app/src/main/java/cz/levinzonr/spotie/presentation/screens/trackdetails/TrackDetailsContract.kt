package cz.levinzonr.spotie.presentation.screens.trackdetails

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.TrackDetails


sealed interface State: BaseState {
    object Idle: State
    object Loading: State
    data class Loaded(val track: TrackDetails): State
}


sealed interface Change: BaseChange{
    data class Loaded(val track: TrackDetails) : Change
    object LoadStarted: Change
}

sealed interface Action : BaseAction {
    data class Init(val id: String) : Action
}