package cz.levinzonr.spotie.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import cz.levinzonr.spotie.presentation.components.AppBottomNav
import cz.levinzonr.spotie.presentation.extenstions.composable
import cz.levinzonr.spotie.presentation.navigation.MenuItem
import cz.levinzonr.spotie.presentation.screens.home.ProfileScreen
import cz.levinzonr.spotie.presentation.screens.login.LoginScreen
import cz.levinzonr.spotie.presentation.screens.toptracks.TopTracksScreen
import cz.levinzonr.spotie.presentation.screens.trackdetails.Routes
import cz.levinzonr.spotie.presentation.screens.trackdetails.RoutesActions
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

    private val loginAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        viewModel.dispatch(Action.HandleLoginResult(it.resultCode, it.data))
    }

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val state = navController.currentBackStackEntryAsState().value
                Timber.d("State : ${state?.destination?.route}")
                val viewState by viewModel.stateFlow.collectAsState(initial = State())
                if (viewState.isLoggedIn) {

                    Scaffold(
                        bottomBar = {
                            AppBottomNav(items = listOf(MenuItem.Home, MenuItem.Profile), navController = navController)
                        }
                    ) {
                        NavHost(navController = navController, startDestination = MenuItem.Home.route) {
                            navigation(Routes.tracks.path, MenuItem.Home.route) {
                                composable(Routes.tracks) {
                                    TopTracksScreen(hiltViewModel()) {
                                        Timber.d("On Track: $it")
                                        navController.navigate(RoutesActions.toTrackDetails(it.id))
                                    }
                                }

                                composable(Routes.trackDetails) {
                                    TrackDetailsScreen(hiltViewModel())
                                }
                            }

                            navigation(Routes.profile.path, MenuItem.Profile.route) {
                                composable(Routes.profile) {
                                    ProfileScreen(hiltViewModel())
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
