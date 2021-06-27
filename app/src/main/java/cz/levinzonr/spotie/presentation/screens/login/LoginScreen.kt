package cz.levinzonr.spotie.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import cz.levinzonr.spotie.presentation.screens.login.components.PageController
import cz.levinzonr.spotie.presentation.screens.login.components.TutorialFirstPage
import cz.levinzonr.spotie.presentation.screens.login.components.TutorialLastPage
import cz.levinzonr.spotie.presentation.screens.login.components.TutorialSecondPage
import cz.levinzonr.spotie.presentation.theme.AppTheme

@ExperimentalPagerApi
@Composable
fun LoginScreen(onHandleLoginEvent: () -> Unit) {
    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val state = rememberPagerState(pageCount = 3)
            HorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                state = state
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.7f)
                    ) {
                        when (it) {
                            0 -> TutorialFirstPage()
                            1 -> TutorialSecondPage()
                            2 -> TutorialLastPage(onHandleLoginEvent)
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.padding(23.dp))
            PageController(pagerState = state)
        }
    }
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
