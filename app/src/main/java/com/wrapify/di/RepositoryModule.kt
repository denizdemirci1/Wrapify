package com.wrapify.di

import com.wrapify.data.remote.datasources.PersonalizationDataSource
import com.wrapify.data.repositories.PersonalizationRepository
import com.wrapify.data.repositories.PersonalizationRepositoryImpl
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
abstract class RepositoryModule {

    @Binds
    abstract fun providePersonalizationRepository(
        personalizationDataSource: PersonalizationRepositoryImpl
    ): PersonalizationRepository
}
