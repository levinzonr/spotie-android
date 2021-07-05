package com.avon.avonon.presentation.screens.main.dashboard_v2.components.actions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.avon.avonon.presentation.screens.main.dashboard_v2.components.DashboardActionButton


@Composable
fun DashboardActions(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        DashboardActionButton(icon = Icons.Default.Settings, text = "My Profile Information") {
        }
        Spacer(modifier = Modifier.size(8.dp))
        DashboardActionButton(icon = Icons.Default.AccountBox, text = "Help & Support") {

        }
    }
}