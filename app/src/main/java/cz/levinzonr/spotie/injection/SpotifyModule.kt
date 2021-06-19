package cz.levinzonr.spotie.injection

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
    fun provideSpotifyCredentials() : SpotifyCredentials {
        return SpotifyCredentials(
            clientId = BuildConfig.CLIENT_ID,
            redirectUri = BuildConfig.REDIRECT_URI
        )
    }
}