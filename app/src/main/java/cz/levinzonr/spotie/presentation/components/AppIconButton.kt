package cz.levinzonr.spotie.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.extenstions.appGradient
import cz.levinzonr.spotie.presentation.theme.AppTheme
import cz.levinzonr.spotie.R

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    iconRes: Int = R.drawable.ic_baseline_play_arrow_24,
    onClick: () -> Unit = {}
) {
    Surface(color = Color.Transparent, elevation = 8.dp, shape = CircleShape) {
        IconButton(
            modifier = modifier.background(Brush.linearGradient(MaterialTheme.appGradient), CircleShape),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "",
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }

}


@Preview
@Composable
fun PreviewAppIconButton() {
    AppTheme {
        AppIconButton()
    }
}