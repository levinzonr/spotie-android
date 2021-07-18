package cz.levinzonr.spotie.presentation.screens.newreleases

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.spotie.presentation.screens.newreleases.components.ReleaseItem

@Composable
fun ReleasesScreen(viewModel: ReleasesViewModel = hiltViewModel()) {
    val state = viewModel.stateFlow.collectAsState(initial = State()).value
    LazyColumn {
        items(state.releases) { release ->
            ReleaseItem(release = release)
        }
    }
}