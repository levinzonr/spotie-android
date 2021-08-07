package cz.levinzonr.spotie.presentation.screens.player

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import cz.levinzonr.spotie.domain.models.PlayerState
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.R
import cz.levinzonr.spotie.presentation.components.AppButton
import cz.levinzonr.spotie.presentation.theme.AppTheme
import timber.log.Timber

@Composable
fun PlayerComponent(modifier: Modifier = Modifier, viewModel: PlayerViewModel = hiltViewModel()) {
    val state by viewModel.stateFlow.collectAsState(initial = PlayerState.Idle)
    Timber.d("state : $state")
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        when (val state = state) {
            is PlayerState.Ready -> {
                Surface(
                    elevation = 4.dp
                ) {
                    PlayerReady(
                        track = state.track,
                        isPlaying = state.isPlaying,
                        viewModel::dispatch
                    )
                }
            }
        }
    }

}

@Composable
private fun PlayerError(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        AppButton(text = "_Retry") {

        }
    }
}

@Composable
private fun PlayerReady(
    track: Track,
    isPlaying: Boolean,
    onActionDispatch: (PlayerAction) -> Unit = {}
) {

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f),
            painter = rememberImagePainter(track.imageUrl) {
                error(R.drawable.ic_baseline_pause_24)
                placeholder(R.drawable.ic_baseline_pause_24)
            },
            contentDescription = track.title,
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.size(12.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = track.artistName, style = MaterialTheme.typography.caption)
            Text(text = track.title, style = MaterialTheme.typography.caption)
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { onActionDispatch.invoke(PlayerAction.Previous) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_skip_previous_24),
                    contentDescription = ""
                )
            }

            IconButton(onClick = { onActionDispatch.invoke(PlayerAction.Toggle) }) {
                val iconRes =
                    if (isPlaying) R.drawable.ic_baseline_pause_24 else R.drawable.ic_baseline_play_arrow_24
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = ""
                )
            }
            IconButton(onClick = { onActionDispatch.invoke(PlayerAction.Next) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_skip_next_24),
                    contentDescription = ""
                )
            }
        }


    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun PreviewPlayerComponent() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            PlayerReady(Track(), isPlaying = true)

        }
    }
}
