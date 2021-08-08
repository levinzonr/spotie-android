package cz.levinzonr.spotie.presentation.screens.playlists

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.Playlist


data class State(
    val playlists: List<Playlist> = listOf(),
    val searchQuery: String = "",
    val isLoading: Boolean = false
) : BaseState

sealed interface Change: BaseChange {
    data class PlaylistsLoaded(val data: List<Playlist>) : Change
    object  LoadStarted: Change
    data class QueryChanged(val query: String): Change
}

sealed interface Action: BaseAction {
    object Init: Action
    data class QueryChange(val query: String) : Action
}