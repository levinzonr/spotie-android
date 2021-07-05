package cz.levinzonr.spotie.presentation.screens.trackdetails

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.router.core.Route
import cz.levinzonr.router.core.RouteArg
import cz.levinzonr.router.core.RouteArgType
import cz.levinzonr.spotie.presentation.components.Placeholder

@Route(name = "trackDetails", args = [RouteArg("trackId", type = RouteArgType.StringType)])
@Composable
fun TrackDetailsScreen(viewModel: TrackDetailsViewModel = hiltViewModel()) {
    val state by viewModel.stateFlow.collectAsState(initial = State.Idle)

    when(val state = state) {
        is State.Idle, is State.Loading -> {
            CircularProgressIndicator()
        }
        is State.Loaded -> {
            Placeholder(title = state.track.toString())
        }
    }
}
