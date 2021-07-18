package cz.levinzonr.spotie.presentation.screens.newreleases.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import cz.levinzonr.spotie.domain.models.Album
import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun ReleaseItem(modifier: Modifier = Modifier, release: NewRelease) {
    Row(modifier = modifier) {
        Image(
            modifier = Modifier.size(60.dp),
            painter = rememberGlidePainter(request = release.album.image),
            contentDescription = release.album.title
        )
        
        Column {
            Text(text = release.album.title)
            Text(text = "${release.album.tracksCount} tracks | ${release.album.type}")
        }
    }
}

@Preview
@Composable
fun PreviewReleaseItem() {
    AppTheme {
        ReleaseItem(release = NewRelease())
    }
}