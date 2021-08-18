package cz.levinzonr.spotie.presentation.screens.settings

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import cz.levinzonr.saferoute.annotations.Route

@Composable
@Route(name = "settings")
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    Scaffold() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Settings")
        }
    }
}

@Preview("Settings - Dark", uiMode = UI_MODE_NIGHT_YES)
@Preview("Settings - Light", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
