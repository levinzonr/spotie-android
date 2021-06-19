package cz.levinzonr.compose.template.presentation.extenstions

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import cz.levinzonr.compose.template.presentation.screens.details.RouteSpec

fun NavGraphBuilder.composable(spec: RouteSpec, deepLinks: List<NavDeepLink> = listOf(), content: @Composable (NavBackStackEntry) -> Unit) {
    composable(spec.path, spec.navArgs, deepLinks, content)
}
