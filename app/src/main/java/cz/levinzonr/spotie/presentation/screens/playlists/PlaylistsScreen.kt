package cz.levinzonr.spotie.presentation.screens.playlists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import cz.levinzonr.spotie.domain.models.Playlist
import cz.levinzonr.spotie.presentation.screens.playlists.components.PlaylistItem
import cz.levinzonr.spotie.presentation.screens.playlists.components.PlaylistSearchBar


@Composable
fun PlaylistsScreen(
    state: State,
    onEvent: (PlaylistScreenEvent) -> Unit = {}
) {

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            PlaylistSearchBar(
                query = state.searchQuery,
                onQueryChange = { onEvent(PlaylistScreenEvent.SearchQueryChange(it)) })
        }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.playlists) {
                PlaylistItem(
                    name = it.name,
                    image = it.imageUrl
                )
            }
        }
    }


}

@Preview
@Composable
fun PreviewPlaylistScreen() {

}