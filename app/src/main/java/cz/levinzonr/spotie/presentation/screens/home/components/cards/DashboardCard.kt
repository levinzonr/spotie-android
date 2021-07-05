package com.avon.avonon.presentation.screens.main.dashboard_v2.components.cards

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun DashboardCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(384.dp)
            .clip(RoundedCornerShape(8.dp)),
        shape = CutoutShape()
    ) {
        content.invoke()
    }
}

class CutoutShape(
    private val cutoutWidth: Dp = 75.dp,
    private val cutoutHeight: Dp = 15.dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val cutoutWidth = with(density) { cutoutWidth.roundToPx() }
        val cutoutHeight = with(density) { cutoutHeight.roundToPx() }
        return Outline.Generic(Path().apply {
            val center = size.width / 2
            val curveStartX = center - (cutoutWidth / 2)
            val curveEndX = center + cutoutWidth / 2
            val firstControlPointX = curveStartX + cutoutWidth / 2
            val secondControlPointX = curveEndX - cutoutWidth / 2
            moveTo(0f, 0f)
            lineTo(curveStartX, 0f)
            cubicTo(
                firstControlPointX,
                cutoutHeight.toFloat(),
                secondControlPointX,
                cutoutHeight.toFloat(),
                curveEndX,
                0f
            )
            lineTo(size.width, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            lineTo(0f, 0f)
        })
    }
}


@Preview
@Composable
fun PreviewDashboardCard() {
    DashboardCard {

    }
}
