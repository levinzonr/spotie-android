package cz.levinzonr.spotie.presentation.screens.toptracks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.levinzonr.router.core.Route
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.screens.player.PlayerComponent
import cz.levinzonr.spotie.presentation.screens.toptracks.components.TracksCarousel

@Composable
@Route("tracks")
fun TopTracksScreen(viewModel: TopTracksViewModel = viewModel(), onTrackClicked: (Track) -> Unit) {
    val state = viewModel.stateFlow.collectAsState(initial = State.Idle).value
    Scaffold {
        when (state) {
            is State.Idle, State.Loading -> CircularProgressIndicator()
            is State.ShowContent -> {
                Column {

                    Text(
                        text = "Your top tracks",
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.padding(16.dp)
                    )

                    TracksCarousel(
                        tracks = state.topTracks.shortTerm,
                        title = "_First",
                        onTrackClicked = onTrackClicked
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    TracksCarousel(
                        tracks = state.topTracks.midTerm,
                        title = "Second",
                        onTrackClicked = onTrackClicked
                    )

                    Spacer(modifier = Modifier.size(16.dp))

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

@Preview
@Composable
fun PreviewTopScreen() {
    TopTracksScreen() {
    }
}
