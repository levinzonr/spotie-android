package cz.levinzonr.spotie.presentation.screens.playlists.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.extenstions.appGradient
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun PlaylistSearchBar(query: String, onQueryChange: (String) -> Unit) {
    Surface(
        elevation = 8.dp,
        modifier = Modifier.fillMaxWidth().height(64.dp),
        color = MaterialTheme.colors.background
    ) {
        BasicTextField(
            value = query,
            onValueChange = onQueryChange,
            cursorBrush = Brush.verticalGradient(MaterialTheme.appGradient),
            decorationBox = {

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Spacer(modifier = Modifier.size(8.dp))

                Icon(
                    imageVector = Icons.Rounded.Search,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )

                if (query.isEmpty()) {
                    Text(
                        text = "Search playlist by name",
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray
                    )
                } else {
                    it.invoke()
                }
            }
        })
    }
}

@Preview
@Composable
fun PreviewEmptySearchBar() {
    AppTheme {
        PlaylistSearchBar(query = "", onQueryChange = {})
    }
}


@Preview
@Composable
fun PreviewFieldSearchBar() {
    AppTheme {
        PlaylistSearchBar(query = "Query", onQueryChange = {})
    }
}