package cz.levinzonr.spotie.presentation.screens.toptracks.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun TracksCarousel(
    tracks: List<Track>,
    title: String,
    modifier: Modifier = Modifier,
    onTrackClicked: (Track) -> Unit
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            LazyRow() {
                items(tracks.count()) { index ->
                    Spacer(modifier = Modifier.size(4.dp))
                    val track = tracks[index]
                    TrackCarouselItem(track = track, onClick = { onTrackClicked.invoke(track) })
                }
            }
        }
    }

}

@Preview
@Composable
fun PreviewTracksCarousel() {
    AppTheme {
        val items = List(3) { Track() }
        TracksCarousel(tracks = items, title = "Top Tracks") {
        }
    }

}
