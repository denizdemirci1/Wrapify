package com.wrapify.data.services

import com.wrapify.model.response.TopArtistsResponse
import com.wrapify.model.response.TopTracksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SpotifyService {

    companion object {
        const val BASE_URL = "https://api.spotify.com/v1/"
    }

    @GET("me/top/artists")
    suspend fun fetchTopArtists(
        @Query("time_range") timeRange: String?,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int,
    ): TopArtistsResponse

    @GET("me/top/tracks")
    suspend fun fetchTopTracks(
        @Query("time_range") timeRange: String?,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int,
    ): TopTracksResponse
}