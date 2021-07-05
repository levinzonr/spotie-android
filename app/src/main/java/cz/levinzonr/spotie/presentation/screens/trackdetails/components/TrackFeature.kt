package cz.levinzonr.spotie.presentation.screens.trackdetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TrackFeature(modifier: Modifier = Modifier, label: String, value: String) {
    Card(modifier) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, style = MaterialTheme.typography.h6)
            Text(text = label, style = MaterialTheme.typography.subtitle1)
        }
    }
}

@Preview
@Composable
fun TrackFeaturePreview() {
    TrackFeature(label = "Valence", value = "43%")
}