package cz.levinzonr.spotie.presentation.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.levinzonr.spotie.presentation.components.AppButton


@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AppButton(text = "Login") {
            viewModel.dispatch(Action.LoginClicked)
        }
    }
}