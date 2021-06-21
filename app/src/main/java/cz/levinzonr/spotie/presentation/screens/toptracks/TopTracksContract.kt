package cz.levinzonr.spotie.presentation.screens.toptracks

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.TopTracks

sealed interface State: BaseState {
    object Idle :State
    data class ShowContent(val topTracks: TopTracks) : State
    object Loading: State
}

sealed interface Change: BaseChange {
    object LoadingStarted: Change
    data class LoadingFinished(val topTracks: TopTracks): Change
}

sealed interface Action: BaseAction {
    object Init: Action
}
