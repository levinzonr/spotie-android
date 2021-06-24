package cz.levinzonr.spotie.presentation.screens.login.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.extenstions.appGradient
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.presentation.theme.LightGrey

@Composable
fun PageIndicator(modifier: Modifier = Modifier, isSelected: Boolean) {
    val size = if (isSelected) 24.dp else 12.dp
    val colors = MaterialTheme.appGradient
    Canvas(modifier = Modifier.size(size)) {
        when(isSelected) {
            true -> {
                drawCircle(
                    center = this.center,
                    brush = Brush.linearGradient(colors),
                )
            }
            false -> {
                drawCircle(
                    center = center,
                    color = LightGrey,
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewPageIndicator() {
    AppTheme {
        PageIndicator(isSelected = false)

    }
}

@Preview
@Composable
fun PreviewPageIndicatorEnabled() {
    AppTheme {
        PageIndicator(isSelected = true)
    }
}