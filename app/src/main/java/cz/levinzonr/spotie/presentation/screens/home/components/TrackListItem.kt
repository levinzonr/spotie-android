package cz.levinzonr.spotie.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun TrackListItem(modifier: Modifier = Modifier, track: Track) {
        Row(modifier = modifier
            .height(60.dp)
            .fillMaxWidth()) {
            Image(
                painter = rememberGlidePainter(request = track.imageUrl),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(),
                contentScale = ContentScale.Fit
            )

            Text(text = track.title)
        }

}

@Preview
@Composable
fun PreviewTrackItem() {
    AppTheme {
        TrackListItem(track = Track())
    }
}