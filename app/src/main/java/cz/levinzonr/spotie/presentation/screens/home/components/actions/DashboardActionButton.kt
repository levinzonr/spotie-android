package com.avon.avonon.presentation.screens.main.dashboard_v2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun DashboardActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.weight(0.1f)
            )
            Text(
                text = text,
                modifier = Modifier
                    .weight(0.8f)
                    .padding(12.dp),
                style = MaterialTheme.typography.subtitle1
            )

            Image(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier.weight(0.1f)
            )
        }
    }
}

@Preview
@Composable
fun PreviewDashboardActionButton() {
    AppTheme {
        DashboardActionButton(icon = Icons.Default.Home, text = "Home") {

        }
    }

}