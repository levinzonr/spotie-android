package cz.levinzonr.spotie.injection

import cz.levinzonr.spotie.data.ModelAppRepository
import cz.levinzonr.spotie.data.repository.*
import cz.levinzonr.spotie.domain.repositories.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepository(repository: ModelAppRepository): ModelRepository

    @Binds
    @Singleton
    fun bindTokenRepository(repository: TokenRepositoryImpl): TokenRepository

    @Binds
    @Singleton
    fun bindAuthRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    fun tracksRepository(repository: TracksRepositoryImpl): TracksRepository

    @Binds
    @Singleton
    fun bindFeatuersRepo(repository: TrackFeaturesRepositoryImpl): TrackFeaturesRepository

    @Binds
    @Singleton
    fun bindPlaylistsRepository(repository: PlaylistsRepositoryImpl) : PlaylistsRepository
}
