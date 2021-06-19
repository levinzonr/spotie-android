package cz.levinzonr.compose.template.injection

import cz.levinzonr.compose.template.data.storage.PrefManagerImpl
import cz.levinzonr.compose.template.domain.manager.PrefManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface StorageModule {

    @Binds
    @Singleton
    fun bindPrefManager(prefManagerImpl: PrefManagerImpl): PrefManager
}
