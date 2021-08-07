package cz.levinzonr.spotie.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.components.AppButton
import cz.levinzonr.spotie.presentation.components.AppButtonType

@Composable
fun TopTracksPreview(title: String, tracks: List<Track>, onSeeAll: () -> Unit = {}) {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.alignByBaseline(),
            )
            AppButton(
                text = "See all", type = AppButtonType.Text,
                modifier = Modifier.alignByBaseline()
            ) {
                onSeeAll.invoke()
            }
        }
        tracks.take(3).forEach {
            TrackListItem(track = it)
        }
    }
}