package cz.levinzonr.spotie.presentation.screens.playlists.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.components.AlbumImage

@Composable
fun PlaylistItem(
    modifier: Modifier = Modifier,
    name: String,
    image: String?
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AlbumImage(
            url = image,
            size = 60.dp
        )
        Text(
            text = name,
            style = MaterialTheme.typography.body1
        )
    }
}