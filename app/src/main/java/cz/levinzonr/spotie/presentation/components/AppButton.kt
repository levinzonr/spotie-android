package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.extenstions.appGradient
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.presentation.utils.UnitAction

enum class AppButtonType {
    Filled, Outlined, Text
}

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    type: AppButtonType = AppButtonType.Filled,
    onClick: UnitAction
) {
    when (type) {
        AppButtonType.Filled -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled
        ) {
            AppButtonContent(text = text, icon = icon, color = MaterialTheme.colors.onPrimary)
        }
        AppButtonType.Outlined -> OutlinedButton(
            onClick = onClick,
            border = GradientStroke(3.dp, MaterialTheme.appGradient),
            modifier = modifier,
            enabled = enabled
        ) {
            AppButtonContent(text = text, icon = icon, color = MaterialTheme.colors.primary)
        }

        AppButtonType.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
            ) {
                AppButtonContent(text = text, icon = icon, color = MaterialTheme.colors.primary)
            }
        }
    }
}

private fun GradientStroke(width: Dp, colors: List<Color>): BorderStroke {
    return BorderStroke(
        width,
        Brush.radialGradient(
            colors,
            center = Offset(41f, 41f),
            radius = 300f
        )
    )
}

@Composable
private fun AppButtonContent(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter?,
    color: Color = MaterialTheme.colors.onSurface
) {
    Row(modifier = modifier.padding(horizontal = 24.dp, vertical = 8.dp)) {
        icon?.let {
            Image(
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.FillBounds,
                painter = it,
                contentDescription = "",
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            color = color
        )
    }
}

@Preview
@Composable
fun PreviewOutlinedButton() {
    AppTheme {
        AppButton(text = "Outlined", type = AppButtonType.Outlined) {
        }
    }
}

@Preview
@Composable
fun PreviewTextButton() {
    AppTheme {
        AppButton(text = "Text  buttpm", type = AppButtonType.Text) {
        }
    }
}

@Preview(name = "Primary Button")
@Composable
fun PreviewAppButton() {
    AppTheme {
        AppButton(text = "Text") {}
    }
}

@Preview(name = "Disabled Button")
@Composable
fun PreviewDisabledAppButton() {
    AppTheme {
        AppButton(text = "Text", enabled = false) {}
    }
}
