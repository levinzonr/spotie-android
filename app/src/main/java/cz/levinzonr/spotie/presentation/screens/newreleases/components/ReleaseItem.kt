package cz.levinzonr.spotie.presentation.screens.newreleases.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.presentation.components.AlbumImage
import cz.levinzonr.spotie.presentation.extenstions.appGradient
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.R

@Composable
fun ReleaseItem(
    modifier: Modifier = Modifier,
    release: NewRelease,
    onAddToLibrary: () -> Unit = {},
    onItemClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onItemClick.invoke() }
            .fillMaxWidth()
            .height(70.dp)
    ) {
        AlbumImage(url = release.album.image, modifier = Modifier.size(70.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
                .weight(8f),
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = release.album.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = release.artistName,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
            )

            Text(
                text = "${release.album.type}",
                style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .layoutId("badge")
                    .background(
                        brush = Brush.linearGradient(MaterialTheme.appGradient),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 8.dp)
            )

        }


        IconButton(modifier = Modifier.weight(2f), onClick = { onAddToLibrary.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_library_add_24),
                contentDescription = null,
                tint = MaterialTheme.colors.primary
            )
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