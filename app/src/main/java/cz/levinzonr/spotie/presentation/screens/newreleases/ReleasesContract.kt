package cz.levinzonr.spotie.presentation.screens.newreleases

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.Album

data class State(
    val albums: List<Album> = listOf()
): BaseState


sealed interface Change : BaseChange {
    object Loading: Change
    data class Loaded(val data: List<Album>) : Change
}

sealed interface Action: BaseAction {
    object Init: Action
}