package cz.levinzonr.spotie.presentation.screens.toptracks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.accompanist.glide.rememberGlidePainter
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.utils.UnitAction

@Composable
fun TrackItem(modifier: Modifier = Modifier, track: Track, onClick: UnitAction = {}) {
    Column(
        modifier = modifier.clickable { onClick.invoke() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = rememberGlidePainter(
                request = track.imageUrl,
                requestBuilder = {
                    transform(RoundedCorners(16))
                }
            ),
            contentDescription = "track_image"
        )
        Text(text = track.artistName)
        Text(text = track.title)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTrackItem() {
    val url =
        "https://i.ytimg.com/an_webp/bC06Zt_WaM4/mqdefault_6s.webp?du=3000&sqp=CMa2wYYG&rs=AOn4CLBLff7_aVDhluxRDCHUz2XS4HOC6g"
    TrackItem(track = Track("Title", url, "Artist Name"))
}
