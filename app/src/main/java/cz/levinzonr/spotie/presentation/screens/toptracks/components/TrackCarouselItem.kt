package cz.levinzonr.spotie.presentation.screens.toptracks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.components.ImageWithText
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.presentation.utils.UnitAction

@Composable
fun TrackCarouselItem(modifier: Modifier = Modifier, track: Track, onClick: UnitAction = {}) {
    ImageWithText(
        title = track.title,
        subtitle = track.artistName,
        imageUrl = track.imageUrl,
        modifier = modifier.clickable { onClick.invoke() }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTrackItem() {
    AppTheme {
        TrackCarouselItem(track = Track())
    }
}
