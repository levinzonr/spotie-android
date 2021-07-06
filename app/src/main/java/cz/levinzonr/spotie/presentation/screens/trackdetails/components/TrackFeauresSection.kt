package cz.levinzonr.spotie.presentation.screens.trackdetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.levinzonr.spotie.domain.models.TrackFeatures
import kotlin.math.roundToInt

@Composable
fun TrackFeaturesSection(modifier: Modifier = Modifier, features: TrackFeatures) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TrackFeature(label = "Danceability", value = features.danceability.toPercentageString())
        TrackFeature(label = "BPM", value = features.rhythm.roundToInt().toString())
        TrackFeature(label = "Energy", value = features.energy.toPercentageString())
    }
}

private fun Double.toPercentageString() = "${(this * 100).roundToInt()} %"

@Preview
@Composable
fun PReviewTrackFeatures() {
   TrackFeaturesSection(features = TrackFeatures())
}