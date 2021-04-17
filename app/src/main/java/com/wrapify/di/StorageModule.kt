package com.wrapify.di

import com.wrapify.util.storage.SharedPrefsStorage
import com.wrapify.util.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class StorageModule {

    @Binds
    @Singleton
    abstract fun provideStorage(storage: SharedPrefsStorage): Storage
}
