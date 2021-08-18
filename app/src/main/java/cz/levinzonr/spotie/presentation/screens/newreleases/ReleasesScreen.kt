package cz.levinzonr.spotie.presentation.screens.newreleases

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.statusBarsPadding
import cz.levinzonr.saferoute.annotations.Route
import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.presentation.screens.newreleases.components.ReleaseItem

@Composable
@Route("newReleases")
fun ReleasesScreen(
    state: State = State(),
    onEvent: (ReleasesScreenEvent) -> Unit = {}
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.statusBarsPadding()
    ) {
        items(state.releases) { release ->
            ReleaseItem(
                release = release,
                onAddToLibrary = { onEvent(ReleasesScreenEvent.AddToLibrary(release)) },
                onItemClick= { onEvent(ReleasesScreenEvent.AddToLibrary(release)) }
            )
        }
    }
}