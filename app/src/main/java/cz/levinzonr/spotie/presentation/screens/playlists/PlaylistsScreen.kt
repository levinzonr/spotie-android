package cz.levinzonr.spotie.presentation.screens.playlists

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cz.levinzonr.spotie.domain.models.Playlist


@Composable
fun PlaylistsScreen(
    state: State,
    onPlaylistClick: (Playlist) -> Unit = {}
) {
    LazyColumn {
        items(state.playlists) {
            Text(text = it.name)
        }
    }
}

@Preview
@Composable
fun PreviewPlaylistScreen() {

}