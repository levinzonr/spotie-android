package cz.levinzonr.spotie.presentation.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import cz.levinzonr.spotie.R

val appFontFamily = sourceSansProFamily

val sourceSansProFamily get() = FontFamily(
    listOf(
        Font(R.font.source_sans_pro_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.source_sans_pro_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.source_sans_pro_semibold, FontWeight.SemiBold, FontStyle.Normal),
    )
)
