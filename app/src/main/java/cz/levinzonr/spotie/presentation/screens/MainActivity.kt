package cz.levinzonr.spotie.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import cz.levinzonr.spotie.presentation.extenstions.composable
import cz.levinzonr.spotie.presentation.navigation.MenuItem
import cz.levinzonr.spotie.presentation.screens.home.HomeOrchestrator
import cz.levinzonr.spotie.presentation.screens.home.HomeScreenEvent
import cz.levinzonr.spotie.presentation.screens.home.HomeScreen
import cz.levinzonr.spotie.presentation.screens.login.LoginScreen
import cz.levinzonr.spotie.presentation.screens.newreleases.ReleasesOrchestrator
import cz.levinzonr.spotie.presentation.screens.newreleases.ReleasesScreen
import cz.levinzonr.spotie.presentation.screens.player.PlayerComponent
import cz.levinzonr.spotie.presentation.screens.playlists.PlaylistOrhestrator
import cz.levinzonr.spotie.presentation.screens.profile.Routes
import cz.levinzonr.spotie.presentation.screens.profile.RoutesActions
import cz.levinzonr.spotie.presentation.screens.trackdetails.TrackDetailsScreen
import cz.levinzonr.spotie.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var authorizationRequest: AuthorizationRequest

    private val loginAction =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            viewModel.dispatch(Action.HandleLoginResult(it.resultCode, it.data))
        }

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            val uiController = rememberSystemUiController()
            SideEffect {
                uiController.setStatusBarColor(Color.Transparent, true)
            }

            AppTheme {
                ProvideWindowInsets {

                    val navController = rememberNavController()
                    val state = navController.currentBackStackEntryAsState().value
                    Timber.d("State : ${state?.destination?.route}")
                    val viewState by viewModel.stateFlow.collectAsState(initial = State())
                    if (viewState.isLoggedIn) {

                        Scaffold(
                            modifier = Modifier.navigationBarsPadding(),
                            bottomBar = {
                                PlayerComponent()
                            }
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = MenuItem.Home.route,
                                modifier = Modifier.padding(it)
                            ) {
                                navigation(Routes.tracks.path, MenuItem.Home.route) {
                                    composable(Routes.tracks) {
                                        HomeOrchestrator(navController = navController)
                                    }

                                    composable(Routes.newReleases) {
                                        ReleasesOrchestrator(
                                            viewModel = hiltViewModel(),
                                            navController = navController
                                        )
                                    }

                                    composable(Routes.trackDetails) {
                                        TrackDetailsScreen(hiltViewModel())
                                    }

                                    composable(Routes.playlists) {
                                        PlaylistOrhestrator(
                                            viewModel = hiltViewModel(),
                                            navHostController = navController
                                        )
                                    }
                                }
                            }
                        }
                    } else {
                        LoginScreen(
                            onHandleLoginEvent = {
                                loginAction.launch(
                                    AuthorizationClient.createLoginActivityIntent(
                                        this,
                                        authorizationRequest
                                    )
                                )
                            }
                        )
                    }

                }
            }
        }
    }
}
