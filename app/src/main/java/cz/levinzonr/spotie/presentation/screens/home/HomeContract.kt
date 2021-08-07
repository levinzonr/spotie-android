package cz.levinzonr.spotie.presentation.screens.home

import cz.levinzonr.roxie.BaseAction
import cz.levinzonr.roxie.BaseChange
import cz.levinzonr.roxie.BaseState
import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.domain.models.TopTracks
import cz.levinzonr.spotie.domain.models.Track

data class State(
    val topTracks: TopTracks = TopTracks(),
    val releases: List<NewRelease> = List(3) { NewRelease() }
) : BaseState

sealed interface Action : BaseAction {
    object Init: Action
}

sealed interface Change: BaseChange {
    object LoadingStarted: Change
    data class TopTracksLoaded(val data: TopTracks) : Change
    data class NewReleasedLoaded(val releases: List<NewRelease>) : Change
}


sealed interface HomeScreenEvent {
    object ExploreNewReleases: HomeScreenEvent
    data class TrackClick(val track: Track): HomeScreenEvent
    class SeeTopTracks: HomeScreenEvent
}