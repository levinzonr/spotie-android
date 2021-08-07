package cz.levinzonr.spotie.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Green,
    primaryVariant = LightGreen,
    secondary = Blue,
    background = Grey4,
    surface = White,
    onPrimary = White,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black
)

private val DarkColorsPalette = darkColors(
    primary = LightGreen,
    primaryVariant = LightGreen,
    secondary = Blue,
    background = Black,
    surface = DarkGrey,
    onPrimary = Black,
    onSecondary = White,
    onBackground = White,
    onSurface = White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) LightColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
