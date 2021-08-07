package cz.levinzonr.spotie.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.components.AlbumImage
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun TrackListItem(modifier: Modifier = Modifier, track: Track) {
    Row(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
    ) {
        AlbumImage(
            url = track.imageUrl,
            modifier = Modifier.size(60.dp),
            cornerRadius = 8.dp
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 8.dp).fillMaxHeight()
        ) {
            Text(
                text = track.title
            )
            Text(
                text = track.artistName,
                style = MaterialTheme.typography.body2
            )
        }

    }

}

@Preview
@Composable
fun PreviewTrackItem() {
    AppTheme {
        TrackListItem(track = Track())
    }
}