package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    icon: ImageVector? = null,
    type: AppButtonType = AppButtonType.Filled,
    onClick: UnitAction
) {
    when (type) {
        AppButtonType.Filled -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled
        ) {
            AppButtonContent(text = text, icon = icon)
        }
        AppButtonType.Outlined -> OutlinedButton(
            onClick = onClick,
            border = GradientStroke(2.dp, MaterialTheme.appGradient),
            modifier = modifier,
            enabled = enabled
        ) {
            AppButtonContent(text = text, icon = icon)
        }

        AppButtonType.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
            ) {
                AppButtonContent(text = text, icon = icon)
            }
        }
    }
}
private fun GradientStroke(width: Dp, colors: List<Color>) : BorderStroke {
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
private fun AppButtonContent(modifier: Modifier = Modifier, text: String, icon: ImageVector?) {
    Row(modifier =  modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
        icon?.let {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(end = 4.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onSurface
        )
    }
}


@Preview
@Composable
fun PreviewOutlinedButton() {
    AppTheme {
        AppButton(text = "Outlined", icon = Icons.Default.PlayArrow, type = AppButtonType.Outlined) {
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
