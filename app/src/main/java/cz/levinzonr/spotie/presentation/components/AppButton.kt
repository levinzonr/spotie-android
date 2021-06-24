package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.SolidColor
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
    type: AppButtonType = AppButtonType.Filled,
    onClick: UnitAction
) {
    val child = @Composable {
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            modifier =  modifier.padding(horizontal = 32.dp),
            color = MaterialTheme.colors.onSurface
        )
    }
    when (type) {
        AppButtonType.Filled -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled
        ) {
            child.invoke()
        }
        AppButtonType.Outlined -> OutlinedButton(
            onClick = onClick,
            border = GradientStroke(2.dp, MaterialTheme.appGradient),
            modifier = modifier,
            enabled = enabled
        ) {
            child.invoke()
        }
        AppButtonType.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
            ) {
                child.invoke()
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
