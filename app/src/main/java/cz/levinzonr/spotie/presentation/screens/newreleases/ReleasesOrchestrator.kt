package cz.levinzonr.spotie.presentation.screens.newreleases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import cz.levinzonr.spotie.presentation.screens.profile.RoutesActions
import timber.log.Timber

@Composable
fun ReleasesOrchestrator(
    viewModel: ReleasesViewModel,
    navController: NavController
) {
    val state = viewModel.stateFlow.collectAsState(initial = State()).value

    val result = navController.currentBackStackEntry?.savedStateHandle?.let {  }
    Timber.d("Result $result")

    /*LaunchedEffect(key1 = "state") {
        val id = navController.currentBackStackEntry?.savedStateHandle?.get<String>("id")
        if (id != null) {
            Timber.d("Playlist id: $id")
            // navController.previousBackStackEntry?.savedStateHandle?.set("id", null)
        }
    }*/

    ReleasesScreen(state) {
        when(it) {
            is ReleasesScreenEvent.ReleaseClick -> {

            }
            is ReleasesScreenEvent.AddToLibrary -> {
                navController.navigate(RoutesActions.toPlaylists())
            }
        }
    }
}