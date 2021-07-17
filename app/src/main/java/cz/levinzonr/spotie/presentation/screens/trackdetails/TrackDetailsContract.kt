package cz.levinzonr.spotie.presentation.screens.trackdetails

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.TrackDetails

sealed interface State : BaseState {
    object Idle : State
    object Loading : State
    data class Loaded(val details: TrackDetails, val isPlaying: Boolean) : State
}

sealed interface Change : BaseChange {
    data class Loaded(val track: TrackDetails) : Change
    object LoadStarted : Change
    data class TrackPlaybackStateChanged(val isPlaying: Boolean) : Change
}

sealed interface Action : BaseAction {
    data class Init(val id: String) : Action
    object TogglePlaybackPressed: Action
    data class ActiveTrackChanged(val id: String, val isPlaying: Boolean) : Action
}
