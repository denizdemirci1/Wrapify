package com.wrapify.di

import com.wrapify.data.remote.datasources.PersonalizationDataSource
import com.wrapify.data.repositories.PersonalizationRepository
import com.wrapify.data.repositories.PersonalizationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun providePersonalizationRepository(
        personalizationDataSource: PersonalizationDataSource
    ): PersonalizationRepository {
        return PersonalizationRepositoryImpl(personalizationDataSource)
    }
}
