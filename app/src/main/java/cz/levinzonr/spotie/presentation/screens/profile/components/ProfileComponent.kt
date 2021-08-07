package cz.levinzonr.spotie.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import cz.levinzonr.spotie.domain.models.User
import cz.levinzonr.spotie.presentation.theme.AppTheme

@Composable
fun UserInfo(user: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier.size(120.dp),
            contentDescription = user.displayName,
            painter = rememberImagePainter(user.imageUrl) {
                transformations(CircleCropTransformation())
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = user.displayName)
    }
}

@Preview
@Composable
fun PreviewUserInfo() {
    AppTheme {
        UserInfo(user = User("Display Name", "imager Url"))
    }
}