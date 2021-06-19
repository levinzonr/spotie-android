package cz.levinzonr.spotie.injection

import cz.levinzonr.spotie.BuildConfig
import cz.levinzonr.spotie.domain.models.SpotifyCredentials
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

@Module
@InstallIn(SingletonComponent::class)
object SpotifyModule {

    @Provides
    fun provideSpotifyCredentials() : SpotifyCredentials {
        return SpotifyCredentials(
            clientId = BuildConfig.CLIENT_ID,
            redirectUri = BuildConfig.REDIRECT_URI
        )
    }

    @Provides
    fun provideAuthRequest(credentials: SpotifyCredentials) : AuthorizationRequest {
        return AuthorizationRequest.Builder(
            credentials.clientId,
            AuthorizationResponse.Type.CODE,
            credentials.redirectUri
        ).apply {
            setScopes(arrayOf("app-remote-control", "streaming, user-top-read", "playlist-modify-public"))
        }.build()
    }
}