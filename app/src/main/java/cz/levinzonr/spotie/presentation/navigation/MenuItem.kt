package cz.levinzonr.spotie.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MenuItem(val route: String, val icon: ImageVector) {
    object Home : MenuItem("home-flow", Icons.Rounded.Home)
    object Profile : MenuItem("profile-flow", Icons.Rounded.Settings)
}
