package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.extenstions.albumImage

@Composable
fun AlbumImage(
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    cornerRadius: Dp = 12.dp,
    url: String?
) {
    Surface(
        elevation = 12.dp,
        modifier = modifier.size(size),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Image(
            painter = albumImage(url = url),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}