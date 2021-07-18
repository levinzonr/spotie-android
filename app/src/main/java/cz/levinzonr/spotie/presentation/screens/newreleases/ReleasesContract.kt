package cz.levinzonr.spotie.presentation.screens.newreleases

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.Album
import cz.levinzonr.spotie.domain.models.NewRelease

data class State(
    val releases: List<NewRelease> = listOf()
): BaseState


sealed interface Change : BaseChange {
    object Loading: Change
    data class Loaded(val data: List<NewRelease>) : Change
}

sealed interface Action: BaseAction {
    object Init: Action
}