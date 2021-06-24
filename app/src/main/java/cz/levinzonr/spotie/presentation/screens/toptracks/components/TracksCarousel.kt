package cz.levinzonr.spotie.presentation.screens.toptracks.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.levinzonr.spotie.domain.models.Track

@Composable
fun TracksCarousel(tracks: List<Track>, title: String, modifier: Modifier = Modifier, onTrackClicked: (Track) -> Unit) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.h6)
        LazyRow() {
            items(tracks.count()) { index ->
                val track = tracks[index]
                TrackItem(track = track, onClick = { onTrackClicked.invoke(track) })
            }
        }
    }
}

@Preview
@Composable
fun PreviewTracksCarousel() {
    val url = "https://i.ytimg.com/an_webp/bC06Zt_WaM4/mqdefault_6s.webp?du=3000&sqp=CMa2wYYG&rs=AOn4CLBLff7_aVDhluxRDCHUz2XS4HOC6g"
    val items = List(3) {
        Track("title", url, "Aritst: $it")
    }
    TracksCarousel(tracks = items, title = "Top Tracks") {
    }
}
