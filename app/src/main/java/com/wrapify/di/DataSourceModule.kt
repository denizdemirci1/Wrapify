package com.wrapify.di

import com.wrapify.data.remote.datasources.PersonalizationDataSource
import com.wrapify.data.remote.datasources.PersonalizationDataSourceImpl
import com.wrapify.data.services.SpotifyService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun providePersonalizationDataSource(
        dataSource: PersonalizationDataSourceImpl
    ): PersonalizationDataSource
}
