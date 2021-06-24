package cz.levinzonr.spotie.presentation.screens.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PageController(modifier: Modifier = Modifier, count: Int, current: Int) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(count) {
            PageIndicator(modifier = Modifier.padding(8.dp), isSelected = current == it)
        }
    }
}

@Preview
@Composable
fun PreviewPageController() {
    PageController(count = 3, current = 1)
}