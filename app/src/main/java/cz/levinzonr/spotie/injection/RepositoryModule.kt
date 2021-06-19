package cz.levinzonr.spotie.injection

import cz.levinzonr.spotie.data.ModelAppRepository
import cz.levinzonr.spotie.domain.repositories.ModelRepository
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
}
