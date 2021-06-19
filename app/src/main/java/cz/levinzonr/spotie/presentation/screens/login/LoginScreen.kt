package cz.levinzonr.spotie.presentation.screens.login

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import cz.levinzonr.spotie.presentation.components.AppButton


@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel(), onHandleLoginEvent: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AppButton(text = "Login") {
            onHandleLoginEvent.invoke()
        }
    }
}