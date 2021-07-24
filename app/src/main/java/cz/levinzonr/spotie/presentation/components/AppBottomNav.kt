package cz.levinzonr.spotie.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cz.levinzonr.spotie.presentation.navigation.MenuItem
import timber.log.Timber

@Composable
fun AppBottomNav(items: List<MenuItem>, navController: NavHostController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        Timber.d("Current path: ${currentDestination?.route}")
        items.forEach { screen ->
            val route = currentDestination?.parent?.route ?: currentDestination?.route
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.route) },
                selected = route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true

                    }
                }
            )
        }
    }
}
