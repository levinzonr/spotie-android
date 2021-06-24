package cz.levinzonr.spotie.presentation.extenstions

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import cz.levinzonr.spotie.presentation.screens.trackdetails.RouteSpec

fun NavGraphBuilder.composable(
    spec: RouteSpec,
    deepLinks: List<NavDeepLink> = listOf(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(spec.path, spec.navArgs, deepLinks, content)
}


val MaterialTheme.appGradient : List<Color> @Composable get() {
    return listOf(colors.primary, colors.secondary)
}
