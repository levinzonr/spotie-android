package cz.levinzonr.spotie.presentation.extenstions

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import java.lang.Math.PI
import java.lang.Math.cos
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt


@Composable
fun albumImage(url: String?, cornerRadius: Dp = 16.dp) : ImagePainter {
    return rememberImagePainter(url) {
        transformations(RoundedCornersTransformation(cornerRadius.value))
    }
}

val MaterialTheme.appGradient: List<Color> @Composable get() {
    return listOf(colors.primaryVariant, colors.secondary)
}

fun Modifier.gradientBackground(colors: List<Color>, angle: Float) = this.then(
    Modifier.drawBehind {
        val angleRad = angle / 180f * PI
        val x = cos(angleRad).toFloat() // Fractional x
        val y = sin(angleRad).toFloat() // Fractional y

        val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
        val offset = center + Offset(x * radius, y * radius)

        val exactOffset = Offset(
            x = min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - min(offset.y.coerceAtLeast(0f), size.height)
        )

        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ),
            size = size
        )
    }
)

fun Modifier.gradientBackground(angle: Float, vararg colorsStops: Pair<Float, Color>) = this.then(
    Modifier.drawBehind {
        val angleRad = angle / 180f * PI
        val x = cos(angleRad).toFloat() // Fractional x
        val y = sin(angleRad).toFloat() // Fractional y

        val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
        val offset = center + Offset(x * radius, y * radius)

        val exactOffset = Offset(
            x = min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - min(offset.y.coerceAtLeast(0f), size.height)
        )

        drawRect(
            brush = Brush.linearGradient(
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset,
                colorStops = colorsStops
            ),
            size = size
        )
    }
)
