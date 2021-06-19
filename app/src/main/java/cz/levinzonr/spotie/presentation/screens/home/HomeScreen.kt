package cz.levinzonr.spotie.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import cz.levinzonr.spotie.presentation.screens.details.RoutesActions
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.presentation.utils.NavigationAction
import cz.levinzonr.router.core.Route

@Route("home")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onNavigate: NavigationAction = {}
) {
    val state = viewModel.stateFlow.collectAsState(State()).value
    Scaffold() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onNavigate.invoke(RoutesActions.toDetails("naivagete")) },
            contentAlignment = Alignment.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                Text(text = state.data ?: "")
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeScreenDark() {
    AppTheme {
        HomeScreen()
    }
}

@Preview(device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewHomeScreenLight() {
    AppTheme {
        HomeScreen()
    }
}
