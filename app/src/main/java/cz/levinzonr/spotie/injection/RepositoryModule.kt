package cz.levinzonr.spotie.injection

import cz.levinzonr.spotie.data.ModelAppRepository
import cz.levinzonr.spotie.data.repository.AuthRepositoryImpl
import cz.levinzonr.spotie.data.repository.TokenRepositoryImpl
import cz.levinzonr.spotie.data.repository.UserRepositoryImpl
import cz.levinzonr.spotie.domain.repositories.AuthRepository
import cz.levinzonr.spotie.domain.repositories.ModelRepository
import cz.levinzonr.spotie.domain.repositories.TokenRepository
import cz.levinzonr.spotie.domain.repositories.UserRepository
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
    fun bindTokenRepository(repository: TokenRepositoryImpl) : TokenRepository

    @Binds
    @Singleton
    fun bindAuthRepository(repositoryImpl: AuthRepositoryImpl) : AuthRepository

    @Binds
    @Singleton
    fun bindUserRepository(repository: UserRepositoryImpl) : UserRepository
}
