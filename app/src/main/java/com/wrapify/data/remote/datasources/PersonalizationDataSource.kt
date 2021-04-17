package com.wrapify.data.remote.datasources

import com.wrapify.data.services.SpotifyService
import com.wrapify.model.response.TopArtistsResponse
import com.wrapify.model.response.TopTracksResponse
import com.wrapify.model.util.Result
import javax.inject.Inject

interface PersonalizationDataSource {
    suspend fun fetchTopArtists(timeRange: String?, offset: Int): Result<TopArtistsResponse>

    suspend fun fetchTopTracks(timeRange: String?, offset: Int): Result<TopTracksResponse>
}

class PersonalizationDataSourceImpl @Inject constructor(
    private val service: SpotifyService
) : PersonalizationDataSource {

    override suspend fun fetchTopArtists(
        timeRange: String?,
        offset: Int,
    ): Result<TopArtistsResponse> {
        return try {
            val topArtist = service.fetchTopArtists(timeRange, offset = offset)
            Result.Success(topArtist)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchTopTracks(
        timeRange: String?,
        offset: Int
    ): Result<TopTracksResponse> {
        return try {
            val topTrack = service.fetchTopTracks(timeRange = timeRange, offset = offset)
            Result.Success(topTrack)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
