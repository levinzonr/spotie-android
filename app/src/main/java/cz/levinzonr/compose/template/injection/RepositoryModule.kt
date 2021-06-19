package cz.levinzonr.compose.template.injection

import cz.levinzonr.compose.template.data.ModelAppRepository
import cz.levinzonr.compose.template.domain.repositories.ModelRepository
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
