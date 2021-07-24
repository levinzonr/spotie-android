package cz.levinzonr.spotie.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.router.core.Route
import cz.levinzonr.spotie.presentation.screens.home.components.NewReleasesItem
import cz.levinzonr.spotie.presentation.screens.home.components.TopTracksPreview
import cz.levinzonr.spotie.presentation.screens.toptracks.components.TracksCarousel
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
@Route("home")
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onHandleHomeEvent: (HomeEvent) -> Unit
) {
    val state = viewModel.stateFlow.collectAsState(initial = State()).value
    LazyColumn(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        
        item {
            NewReleasesItem(releases = state.releases) {
                onHandleHomeEvent.invoke(HomeEvent.ExploreNewReleases)
            }
        }

        item {
        }
        
        item {
            Column {
                Text(text = "Your most favorite tracks", style = MaterialTheme.typography.h5)
                TopTracksPreview(tracks = state.topTracks.shortTerm)
            }

        }
        
        item {
            TopTracksPreview(tracks = state.topTracks.midTerm)
        }
        
        item {
            TopTracksPreview(tracks = state.topTracks.longTerm)

        }
        
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    AppTheme {
        HomeScreen() {}
    }
}