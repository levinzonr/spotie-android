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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.accompanist.glide.rememberGlidePainter
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.presentation.utils.UnitAction

@Composable
fun TrackItem(modifier: Modifier = Modifier, track: Track, onClick: UnitAction = {}) {
    Column(
        modifier = modifier
            .size(120.dp)
            .clickable { onClick.invoke() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.weight(9f),
            painter = rememberGlidePainter(
                request = track.imageUrl,
                requestBuilder = {
                    transform(RoundedCorners(16))
                }
            ),
            contentDescription = "track_image"
        )
        Text(
            text = track.artistName,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.weight(2f).padding(top = 4.dp)
        )
        Text(
            text = track.title,
            style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTrackItem() {
    AppTheme {
        TrackItem(track = Track())
    }
}
