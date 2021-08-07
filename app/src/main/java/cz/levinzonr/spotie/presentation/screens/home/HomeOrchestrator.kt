package cz.levinzonr.spotie.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import cz.levinzonr.spotie.presentation.screens.profile.RoutesActions

@Composable
fun HomeOrchestrator(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val state = viewModel.stateFlow.collectAsState(initial = State()).value

    HomeScreen(
        state = state,
        onHandleHomeEvent = {
            when (it) {
                is HomeScreenEvent.ExploreNewReleases -> {
                    navController.navigate(RoutesActions.toNewReleases())
                }
                is HomeScreenEvent.TrackClick -> {
                    navController.navigate(RoutesActions.toTrackDetails(it.track.id))
                }

                is HomeScreenEvent.SeeTopTracks -> {

                }
            }
        }
    )
}