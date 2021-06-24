package cz.levinzonr.spotie.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import cz.levinzonr.spotie.presentation.components.AppButton
import cz.levinzonr.spotie.presentation.components.AppButtonType
import cz.levinzonr.spotie.presentation.theme.AppTheme

@ExperimentalPagerApi
@Composable
fun LoginScreen(onHandleLoginEvent: () -> Unit) {
    Scaffold() {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = rememberPagerState(pageCount = 3)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (it) {
                        0 -> TutorialFirstPage()
                        1 -> TutorialSecondPage()
                        2 -> TutorialLastPage(onHandleLoginEvent)
                    }
                }
            }
        }

    }
}


@Composable
fun ColumnScope.TutorialFirstPage() {
    TutorialHeaderText(text = "Welcome to Spotie")
    Spacer(modifier = Modifier.padding(vertical = 12.dp))
    TutorialBodyText("Spotie allows to you view your most listened music on Spotify®  over the years",)
}


@Composable
fun ColumnScope.TutorialSecondPage() {
    TutorialHeaderText(text = "Relive your favorite music")
    Spacer(modifier = Modifier.padding(vertical = 12.dp))
    TutorialBodyText(text = "Add them to your playlist once again, learn lyrics and interesting facts about their audio-features")
}


@Composable
fun ColumnScope.TutorialLastPage(onHandleLoginEvent: () -> Unit) {
    TutorialHeaderText(text = "One click away")
    Spacer(modifier = Modifier.padding(vertical = 12.dp))
    TutorialBodyText(text = "Spotie  requires your permission to access your music library")
    Spacer(modifier = Modifier.padding(vertical = 12.dp))
    AppButton(type = AppButtonType.Outlined, text = "Login with Spotify") {
        onHandleLoginEvent.invoke()
    }
}

@Composable
fun TutorialBodyText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 32.dp)
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

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewLoginScreen() {
    AppTheme {
        LoginScreen {

        }
    }
}

