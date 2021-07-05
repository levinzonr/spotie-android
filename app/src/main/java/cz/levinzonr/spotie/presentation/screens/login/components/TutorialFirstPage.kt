package cz.levinzonr.spotie.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.components.AppButton
import cz.levinzonr.spotie.presentation.components.AppButtonType
import cz.levinzonr.spotie.R

@Composable
fun TutorialFirstPage() {
    Text(text = "Welcome to", style = MaterialTheme.typography.h1)
    Spacer(modifier = Modifier.size(24.dp))
    TutorialImage(res = R.drawable.ic_logo_text)
    Spacer(modifier = Modifier.size(100.dp))
    TutorialBodyText("Spotie allows to you view your most listened music on Spotify®  over the years")
}

@Composable
fun TutorialSecondPage() {
    TutorialImage(res = R.drawable.ic_tutorial_step2)
    Spacer(modifier = Modifier.size(56.dp))
    TutorialHeaderText(text = "Relive your favorite music")
    Spacer(modifier = Modifier.size(56.dp))
    TutorialBodyText(text = "Add them to your playlist once again, learn lyrics and interesting facts about their audio-features")
}


@Composable
fun TutorialLastPage(onHandleLoginEvent: () -> Unit) {

    TutorialImage(res = R.drawable.ic_tutorial_step3)
    Spacer(modifier = Modifier.size(50.dp))
    TutorialHeaderText(text = "One click away")
    Spacer(modifier = Modifier.size(44.dp))
    TutorialBodyText(text = "Spotie  requires your permission to access your music library")
    Spacer(modifier = Modifier.size(56.dp))
    AppButton(
        type = AppButtonType.Outlined,
        icon = painterResource(id = R.drawable.spotify_icon_rgb_green),
        text = "Login with Spotify"
    ) {
        onHandleLoginEvent.invoke()
    }
}

@Composable
private fun TutorialImage(res: Int) {
    Image(
        painter = painterResource(id = res),
        contentDescription = ""
    )
}

@Composable
fun TutorialBodyText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TutorialHeaderText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 32.dp)
    )
}
