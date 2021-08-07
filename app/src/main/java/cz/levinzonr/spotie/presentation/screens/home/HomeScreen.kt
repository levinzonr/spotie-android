package cz.levinzonr.spotie.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import cz.levinzonr.router.core.Route
import cz.levinzonr.spotie.presentation.screens.home.components.NewReleasesItem
import cz.levinzonr.spotie.presentation.screens.home.components.TopTracksPreview
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
@Route("home")
fun HomeScreen(
    state: State,
    onHandleHomeEvent: (HomeScreenEvent) -> Unit
) {
    LazyColumn(
        Modifier.padding(horizontal = 16.dp).statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        item {
            NewReleasesItem(releases = state.releases) {
                onHandleHomeEvent.invoke(HomeScreenEvent.ExploreNewReleases)
            }
        }

        item {
            Column {
                Text(text = "Your most favorite tracks", style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.size(16.dp))
                TopTracksPreview(
                    title = "Over last week",
                    tracks = state.topTracks.shortTerm,
                    onTrackClick = { onHandleHomeEvent(HomeScreenEvent.TrackClick(it)) }
                )
            }

        }

        item {
            TopTracksPreview(
                title = "Over last month",
                tracks = state.topTracks.midTerm,
                onTrackClick = { onHandleHomeEvent(HomeScreenEvent.TrackClick(it)) }
            )
        }

        item {
            TopTracksPreview(
                title = "Over last years",
                tracks = state.topTracks.longTerm,
                onTrackClick = { onHandleHomeEvent(HomeScreenEvent.TrackClick(it)) }
            )

        }

    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    AppTheme {
        HomeScreen(State(), {})
    }
}