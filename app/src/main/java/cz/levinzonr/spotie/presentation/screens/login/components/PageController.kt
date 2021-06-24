package cz.levinzonr.spotie.presentation.screens.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PageController(count: Int, current: Int) {
    Row() {
        repeat(count) {
            PageIndicator(modifier = Modifier.padding(8.dp), isSelected = current == it - 1)
        }
    }
}

@Preview
@Composable
fun PreviewPageController() {
    PageController(count = 3, current = 1)
}