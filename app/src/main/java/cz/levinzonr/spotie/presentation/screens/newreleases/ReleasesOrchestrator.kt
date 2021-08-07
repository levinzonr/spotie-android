package cz.levinzonr.spotie.presentation.screens.newreleases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController

@Composable
fun ReleasesOrchestrator(
    viewModel: ReleasesViewModel,
    navController: NavController
) {
    val state = viewModel.stateFlow.collectAsState(initial = State()).value
    ReleasesScreen(state)
}