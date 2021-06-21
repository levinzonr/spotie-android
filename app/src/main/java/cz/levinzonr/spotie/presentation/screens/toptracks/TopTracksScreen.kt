package cz.levinzonr.spotie.presentation.screens.toptracks

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.levinzonr.router.core.Route
import cz.levinzonr.spotie.presentation.screens.toptracks.components.TracksCarousel

@Composable
@Route("tracks")
fun TopTracksScreen(viewModel: TopTracksViewModel = viewModel()) {
    val state = viewModel.stateFlow.collectAsState(initial = State.Idle).value
    Scaffold {
        when (state) {
            is State.Idle, State.Loading -> CircularProgressIndicator()
            is State.ShowContent -> {
                Column() {
                    TracksCarousel(tracks = state.topTracks.shortTerm) {
                    }

                    TracksCarousel(tracks = state.topTracks.midTerm) {
                    }

                    TracksCarousel(tracks = state.topTracks.longTerm) {
                    }
                }
            }
        }
    }
}
