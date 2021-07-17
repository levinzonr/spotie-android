package cz.levinzonr.spotie.presentation.screens.trackdetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.components.AppIconButton
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.R
import cz.levinzonr.spotie.presentation.components.AppButton
import cz.levinzonr.spotie.presentation.components.AppButtonType

@Composable
fun TrackControls(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    onActionButtonPressed: () -> Unit = {}
) {
    val res =
        if (isPlaying) R.drawable.ic_baseline_pause_24 else R.drawable.ic_baseline_play_arrow_24
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {

        AppButton(text = "To Queue", type = AppButtonType.Text) {

        }

        AppIconButton(
            iconRes = res,
            onClick = onActionButtonPressed
        )

        AppButton(text = "To Playlist", type = AppButtonType.Text) {

        }

    }
}

@Preview
@Composable
fun PreviewTrackControls() {
    AppTheme {
        TrackControls(isPlaying = false) {

        }
    }
}