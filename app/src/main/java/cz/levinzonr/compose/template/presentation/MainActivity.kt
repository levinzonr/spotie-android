package cz.levinzonr.compose.template.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cz.levinzonr.compose.template.presentation.components.AppBottomNav
import cz.levinzonr.compose.template.presentation.components.Placeholder
import cz.levinzonr.compose.template.presentation.extenstions.composable
import cz.levinzonr.compose.template.presentation.navigation.MenuItem
import cz.levinzonr.compose.template.presentation.screens.details.DetailsScreen
import cz.levinzonr.compose.template.presentation.screens.details.Routes
import cz.levinzonr.compose.template.presentation.screens.home.HomeScreen
import cz.levinzonr.compose.template.presentation.screens.settings.SettingsScreen
import cz.levinzonr.compose.template.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val state = navController.currentBackStackEntryAsState().value
                Timber.d("State : ${state?.destination?.route}")
                Surface(color = MaterialTheme.colors.background) {
                    val items = listOf(MenuItem.Home, MenuItem.Settings, MenuItem.Temp)
                    Scaffold(
                        bottomBar = { AppBottomNav(items = items, navController) }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = MenuItem.Home.route,
                            modifier = Modifier.padding(it)
                        ) {
                            navigation(Routes.home.path, MenuItem.Home.route) {
                                composable(Routes.home.path) {
                                    HomeScreen(
                                        hiltViewModel(),
                                        onNavigate = {
                                            navController.navigate(it)
                                        }
                                    )
                                }
                                composable(Routes.details) {
                                    DetailsScreen(hiltViewModel())
                                }
                            }

                            composable(Routes.settings) {
                                SettingsScreen()
                            }
                            composable("temp") {
                                Placeholder()
                            }
                        }
                    }
                }
            }
        }
    }
}
