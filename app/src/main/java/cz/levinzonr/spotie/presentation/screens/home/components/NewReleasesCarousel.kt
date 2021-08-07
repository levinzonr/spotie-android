package cz.levinzonr.spotie.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.presentation.components.AlbumImage
import cz.levinzonr.spotie.presentation.components.AppButton
import cz.levinzonr.spotie.presentation.components.AppButtonType
import cz.levinzonr.spotie.presentation.components.ImageWithText
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun NewReleasesItem(releases: List<NewRelease>, onExploreClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        val artistsString = releases.map { it.artistName }.distinct().take(2).joinToString(",")
        Text(
            text = "New Releases",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$artistsString and ${releases.count() - 2} more",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            val first = releases.first()
            val second = releases[1]
            val third = releases[2]


            AlbumImage(
                url = first.album.image,
                size = 120.dp,
                modifier = Modifier.align(Alignment.Center)
            )

            AlbumImage(
                url = second.album.image,
                modifier = Modifier.align(Alignment.CenterStart)
            )


            AlbumImage(
                url = third.album.image,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        AppButton(
            text = "Explore",
            type = AppButtonType.Outlined,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            onExploreClicked.invoke()
        }
    }
}


@Preview
@Composable
fun PreviewNewReleasesItem() {
    AppTheme {
        NewReleasesItem(releases = List(3) { NewRelease() }) {}
    }
}