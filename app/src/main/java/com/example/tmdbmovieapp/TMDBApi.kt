package com.example.tmdbmovieapp

import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = Constants.TMDB_API_KEY
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String = Constants.TMDB_API_KEY,
        @Query("query") query: String
    ): MovieResponse
}
