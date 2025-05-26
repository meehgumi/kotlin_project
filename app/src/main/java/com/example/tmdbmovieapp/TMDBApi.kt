package com.example.tmdbmovieapp

import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "fr-FR",
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "fr-FR",
        @Query("page") page: Int = 1
    ): MovieResponse
}