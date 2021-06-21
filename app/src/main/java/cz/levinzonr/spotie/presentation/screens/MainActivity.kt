package cz.levinzonr.spotie.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import cz.levinzonr.spotie.presentation.screens.login.LoginScreen
import cz.levinzonr.spotie.presentation.screens.toptracks.TopTracksScreen
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val state = navController.currentBackStackEntryAsState().value
                Timber.d("State : ${state?.destination?.route}")
                val viewState by viewModel.stateFlow.collectAsState(initial = State())
                if (viewState.isLoggedIn) {
                    TopTracksScreen()
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
