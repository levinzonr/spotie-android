package cz.levinzonr.spotie.presentation.screens.trackdetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.presentation.extenstions.gradientBackground
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun TrackHeader(modifier: Modifier = Modifier, track: Track) {
    Box(modifier = modifier.height(300.dp)) {
        Image(
            painter = rememberGlidePainter(request = track.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.BottomStart)
                .gradientBackground(
                    listOf(
                        MaterialTheme.colors.background,
                        Color.Transparent
                    ), 90f
                )
        )


        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = track.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground,
            )
            Text(
                text = "By ${track.artistName}",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground,
            )
        }
    }
}

@Preview
@Composable
fun TrackHeaderPreview() {
    AppTheme {
        TrackHeader(modifier = Modifier.fillMaxWidth(), track = Track())
    }
}