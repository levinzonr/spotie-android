package cz.levinzonr.spotie.injection

import cz.levinzonr.spotie.data.storage.PrefManagerImpl
import cz.levinzonr.spotie.domain.manager.PrefManager
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
