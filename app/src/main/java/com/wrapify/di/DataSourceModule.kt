package com.wrapify.di

import com.wrapify.data.remote.datasources.PersonalizationDataSource
import com.wrapify.data.remote.datasources.PersonalizationDataSourceImpl
import com.wrapify.data.services.SpotifyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataSourceModule {

    @Provides
    @ActivityRetainedScoped
    fun providePersonalizationDataSource(
        spotifyService: SpotifyService
    ): PersonalizationDataSource {
        return PersonalizationDataSourceImpl(spotifyService)
    }
}
