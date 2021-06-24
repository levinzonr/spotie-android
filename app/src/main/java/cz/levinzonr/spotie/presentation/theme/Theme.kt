package cz.levinzonr.spotie.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = LightGreen,
    primaryVariant = LightGreen,
    secondary = Blue,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
