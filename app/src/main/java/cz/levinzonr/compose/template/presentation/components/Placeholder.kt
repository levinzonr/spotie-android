package cz.levinzonr.compose.template.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Placeholder

@Composable
fun Placeholder(modifier: Modifier = Modifier, title: String = "", color: Color = Color.Red) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawLine(
                color,
                start = Offset.Zero,
                end = Offset(size.width, size.height),
                strokeWidth = 4.dp.value
            )
            drawLine(
                color,
                start = Offset(size.width, 0f),
                end = Offset(0f, size.height),
                strokeWidth = 4.dp.value
            )
        }

        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h3,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PlaceholderPrevew() {
    Placeholder(title = "Placeholder")
}
