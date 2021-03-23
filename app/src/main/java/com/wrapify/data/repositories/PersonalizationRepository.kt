package com.wrapify.data.repositories

import com.wrapify.data.remote.datasources.PersonalizationDataSource
import com.wrapify.model.response.TopArtistsResponse
import com.wrapify.model.response.TopTracksResponse
import com.wrapify.model.util.Result

interface PersonalizationRepository {

    suspend fun fetchTopArtists(timeRange: String?, offset: Int): Result<TopArtistsResponse>

    suspend fun fetchTopTracks(timeRange: String?, offset: Int): Result<TopTracksResponse>
}

class PersonalizationRepositoryImpl(
    private val personalizationDataSource: PersonalizationDataSource
) : PersonalizationRepository {
    override suspend fun fetchTopArtists(
        timeRange: String?,
        offset: Int
    ): Result<TopArtistsResponse> {
        return personalizationDataSource.fetchTopArtists(timeRange, offset)
    }

    override suspend fun fetchTopTracks(
        timeRange: String?,
        offset: Int
    ): Result<TopTracksResponse> {
        return personalizationDataSource.fetchTopTracks(timeRange, offset)
    }
}
