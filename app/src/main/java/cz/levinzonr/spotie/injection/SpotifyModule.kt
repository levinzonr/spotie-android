package cz.levinzonr.spotie.injection

import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import cz.levinzonr.spotie.BuildConfig
import cz.levinzonr.spotie.domain.models.SpotifyCredentials
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SpotifyModule {

    @Provides
    fun provideSpotifyCredentials(): SpotifyCredentials {
        return SpotifyCredentials(
            clientId = BuildConfig.CLIENT_ID,
            redirectUri = BuildConfig.REDIRECT_URI,
            clientSecret = BuildConfig.CLIENT_SECRET
        )
    }

    @Provides
    fun provideConnectionParams(credentials: SpotifyCredentials) : ConnectionParams {
        return ConnectionParams.Builder(credentials.clientId)
            .setRedirectUri(credentials.redirectUri)
            .showAuthView(false)
            .build()
    }

    @Provides
    fun provideAuthRequest(credentials: SpotifyCredentials): AuthorizationRequest {
        return AuthorizationRequest.Builder(
            credentials.clientId,
            AuthorizationResponse.Type.CODE,
            credentials.redirectUri
        ).apply {
            setScopes(arrayOf("app-remote-control", "streaming, user-top-read", "playlist-modify-public"))
        }.build()
    }
}
