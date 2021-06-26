package cz.levinzonr.spotie.presentation.screens.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import timber.log.Timber

@ExperimentalPagerApi
@Composable
fun PageController(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    spacing: Dp = 8.dp,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            repeat(pagerState.pageCount) {
                val isActive = pagerState.currentPage == it
                val position = pagerState.currentPageOffset

                val size = if (isActive) 12.dp else 18.dp

                val offset = Modifier.offset {
                    val space = position * (size + spacing).roundToPx()
                    IntOffset(space.toInt(), 0)
                }

                val offsetNegative = Modifier.offset {
                    val space = position * (size + spacing).roundToPx()
                    IntOffset(-space.toInt(), 0)
                }

                val scrollRight = pagerState.currentPageOffset > 0f
                val renderActiveRight = isActive && scrollRight
                val renderLeftLeaving = pagerState.currentPage + 1 == it && scrollRight
                val renderActiveLet = isActive && pagerState.currentPageOffset < 0f
                val renderRightEntering =
                    pagerState.currentPage - 1 == it && pagerState.currentPageOffset < 0f

                val offsetModifier = when {
                    renderRightEntering || renderLeftLeaving -> offsetNegative
                    renderActiveLet || renderActiveRight -> offset
                    else -> Modifier
                }

                PageIndicator(isSelected = isActive, modifier = offsetModifier)
                Spacer(modifier = modifier.size(spacing))
            }
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewPageController() {
    PageController(modifier = Modifier, pagerState = rememberPagerState(pageCount = 3))
}
