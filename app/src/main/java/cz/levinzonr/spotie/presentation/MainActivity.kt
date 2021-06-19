package cz.levinzonr.spotie.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import cz.levinzonr.spotie.presentation.components.AppBottomNav
import cz.levinzonr.spotie.presentation.components.Placeholder
import cz.levinzonr.spotie.presentation.extenstions.composable
import cz.levinzonr.spotie.presentation.navigation.MenuItem
import cz.levinzonr.spotie.presentation.screens.details.DetailsScreen
import cz.levinzonr.spotie.presentation.screens.details.Routes
import cz.levinzonr.spotie.presentation.screens.home.HomeScreen
import cz.levinzonr.spotie.presentation.screens.login.Action
import cz.levinzonr.spotie.presentation.screens.login.LoginScreen
import cz.levinzonr.spotie.presentation.screens.login.LoginViewModel
import cz.levinzonr.spotie.presentation.screens.login.State
import cz.levinzonr.spotie.presentation.screens.settings.SettingsScreen
import cz.levinzonr.spotie.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var authorizationRequest: AuthorizationRequest

    private val loginAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        loginViewModel.dispatch(Action.HandleLoginResult(it.resultCode, it.data))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val state = navController.currentBackStackEntryAsState().value
                Timber.d("State : ${state?.destination?.route}")
                val viewState by loginViewModel.stateFlow.collectAsState(initial = State())
                if (viewState.isLoggedIn) {
                    Placeholder()
                } else {
                    LoginScreen(viewModel(),
                        onHandleLoginEvent = {
                            loginAction.launch(
                                AuthorizationClient.createLoginActivityIntent(
                                    this,
                                    authorizationRequest
                                )
                            )
                        })
                }

            }
        }
    }
}
