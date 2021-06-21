package cz.levinzonr.spotie.presentation.screens.toptracks

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.levinzonr.router.core.Route
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.screens.toptracks.components.TracksCarousel
import cz.levinzonr.spotie.presentation.utils.NavigationAction

@Composable
@Route("tracks")
fun TopTracksScreen(viewModel: TopTracksViewModel = viewModel(), onTrackClicked: (Track) -> Unit) {
    val state = viewModel.stateFlow.collectAsState(initial = State.Idle).value
    Scaffold {
        when (state) {
            is State.Idle, State.Loading -> CircularProgressIndicator()
            is State.ShowContent -> {
                Column() {
                    TracksCarousel(
                        tracks = state.topTracks.shortTerm,
                        title = "_First",
                        onTrackClicked = onTrackClicked
                    )

                    TracksCarousel(
                        tracks = state.topTracks.midTerm,
                        title = "Second",
                        onTrackClicked = onTrackClicked
                    )

                    TracksCarousel(
                        tracks = state.topTracks.longTerm,
                        title = "Last",
                        onTrackClicked = onTrackClicked
                    )

                }
            }
        }
    }
}
