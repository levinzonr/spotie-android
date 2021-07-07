package cz.levinzonr.spotie.presentation.screens.player

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.levinzonr.spotie.domain.models.PlayerState

@Composable
fun PlayerComponent(modifier: Modifier = Modifier, viewModel: PlayerViewModel = hiltViewModel()) {
    val state by viewModel.stateFlow.collectAsState(initial = PlayerState.Idle)
    Box(modifier = modifier) {
        when (val state = state) {
            is PlayerState.Idle -> Text(text = "Idle")
            is PlayerState.Error -> Text(text = "Error: ${state.throwable}")
            is PlayerState.Ready -> Text(text = "Ready: ${state.track.title}")
        }
    }
}

@Preview
@Composable
fun PreviewPlayerComponent() {
    PlayerComponent()
}
