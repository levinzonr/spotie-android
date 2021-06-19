package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val child = @Composable { Text(text = text, style = MaterialTheme.typography.button) }
    when (type) {
        AppButtonType.Filled -> Button(
            onClick = onClick,
            modifier = modifier.padding(8.dp),
            enabled = enabled
        ) {
            child.invoke()
        }
        AppButtonType.Outlined -> OutlinedButton(
            onClick = onClick,
            modifier = modifier.padding(8.dp),
            enabled = enabled
        ) {
            child.invoke()
        }
        AppButtonType.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier.padding(8.dp),
                enabled = enabled,
            ) {
                child.invoke()
            }
        }
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
