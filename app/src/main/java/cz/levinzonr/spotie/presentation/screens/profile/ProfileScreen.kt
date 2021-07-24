package cz.levinzonr.spotie.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.google.accompanist.glide.rememberGlidePainter
import cz.levinzonr.router.core.Route
import cz.levinzonr.spotie.domain.models.User
import cz.levinzonr.spotie.presentation.screens.home.components.UserInfo
import cz.levinzonr.spotie.presentation.screens.player.PlayerComponent
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.presentation.utils.NavigationAction

@Route("profile")
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel(),
    onNavigate: NavigationAction = {}
) {
    val state by viewModel.stateFlow.collectAsState(initial = State())
    Column {
        state.user?.let { UserInfo(user = it) }
        PlayerComponent(Modifier.padding(16.dp), hiltViewModel())
    }

}

@Preview(device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeScreenDark() {
    AppTheme {
        ProfileScreen()
    }
}

@Preview(device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewHomeScreenLight() {
    AppTheme {
        ProfileScreen()
    }
}
