package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation

@Composable
fun ImageWithText(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUrl: String?
) {
    Column(
        modifier = modifier.size(120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.weight(9f),
            painter = rememberImagePainter(imageUrl) {
                transformations(RoundedCornersTransformation(4f))
            },
            contentDescription = "track_image"
        )
        Text(
            text = title,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.weight(2f).padding(top = 4.dp)
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.weight(2f)
        )
    }
}