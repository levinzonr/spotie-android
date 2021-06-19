package cz.levinzonr.compose.template.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.ui.graphics.vector.ImageVector
import cz.levinzonr.compose.template.presentation.screens.details.Routes

sealed class MenuItem(val route: String, val icon: ImageVector) {
    object Home : MenuItem("home-flow", Icons.Rounded.Home)
    object Settings : MenuItem(Routes.settings.path, Icons.Rounded.Settings)
    object Temp : MenuItem("temp", Icons.Rounded.Share)
}
