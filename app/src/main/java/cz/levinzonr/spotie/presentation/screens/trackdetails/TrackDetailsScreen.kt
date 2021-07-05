package cz.levinzonr.spotie.presentation.screens.trackdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.router.core.Route
import cz.levinzonr.router.core.RouteArg
import cz.levinzonr.router.core.RouteArgType

@Route(name = "trackDetails", args = [RouteArg("trackId", type = RouteArgType.StringType)])
@Composable
fun TrackDetailsScreen(viewModel: TrackDetailsViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
}
