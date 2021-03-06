package cz.levinzonr.spotie.presentation.screens.trackdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.saferoute.annotations.Route
import cz.levinzonr.saferoute.annotations.RouteArg
import cz.levinzonr.saferoute.annotations.RouteArgType
import cz.levinzonr.spotie.presentation.screens.trackdetails.components.TrackFeaturesSection
import cz.levinzonr.spotie.presentation.screens.trackdetails.components.TrackHeader
import cz.levinzonr.spotie.R
import cz.levinzonr.spotie.presentation.screens.trackdetails.components.TrackControls

@Route(name = "trackDetails", args = [RouteArg("trackId", type = RouteArgType.StringType)])
@Composable
fun TrackDetailsScreen(viewModel: TrackDetailsViewModel = hiltViewModel()) {
    val state by viewModel.stateFlow.collectAsState(initial = State.Idle)
    when (val state = state) {
        is State.Idle, is State.Loading -> {
            CircularProgressIndicator()
        }
        is State.Loaded -> {
            Scaffold {
                Column {
                    TrackHeader(track = state.details.track)

                    Spacer(modifier = Modifier.size(16.dp))

                    TrackControls(isPlaying = state.isPlaying, onActionButtonPressed = {
                        viewModel.dispatch(Action.TogglePlaybackPressed)
                    })

                    TrackFeaturesSection(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        features = state.details.features
                    )


                }
            }
        }
    }
}

@Preview
@Composable
fun TrackDetailsScrennPreview() {
    TrackDetailsScreen()
}
