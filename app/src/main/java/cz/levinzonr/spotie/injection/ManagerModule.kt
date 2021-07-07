package cz.levinzonr.spotie.injection

import cz.levinzonr.spotie.data.manager.SpotifyPlayerManager
import cz.levinzonr.spotie.domain.manager.PlayerManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {

    @Binds
    fun bindPlayerManager(spotifyPlayerManager: SpotifyPlayerManager): PlayerManager
}
