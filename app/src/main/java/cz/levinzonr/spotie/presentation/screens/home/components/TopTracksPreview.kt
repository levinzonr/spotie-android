package cz.levinzonr.spotie.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.domain.models.Track

@Composable
fun TopTracksPreview(tracks: List<Track>) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Header", style = MaterialTheme.typography.h6)
        tracks.take(3).forEach {
            TrackListItem(track = it)
        }
    }
}