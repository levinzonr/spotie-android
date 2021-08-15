package cz.levinzonr.spotie.presentation.screens.playlists

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import cz.levinzonr.router.core.Route

@Composable
@Route("playlists")
fun PlaylistOrhestrator(
    viewModel: PlaylistsViewModel,
    navHostController: NavHostController
) {
    val state = viewModel.stateFlow.collectAsState(initial = State()).value
    PlaylistsScreen(
        state = state,
        onEvent = {
            when (it) {
                is PlaylistScreenEvent.PlaylistClick -> {
                    navHostController.previousBackStackEntry?.savedStateHandle?.set("id", it.item.id)
                    navHostController.popBackStack()
                }
                is PlaylistScreenEvent.SearchQueryChange -> viewModel.dispatch(Action.QueryChange(it.value))
            }
        }
    )
}