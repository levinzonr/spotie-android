package cz.levinzonr.spotie.presentation.screens.playlists

import cz.levinzonr.spotie.domain.models.Playlist

sealed interface PlaylistScreenEvent {
    data class PlaylistClick(val item: Playlist): PlaylistScreenEvent
    data class SearchQueryChange(val value: String): PlaylistScreenEvent
}