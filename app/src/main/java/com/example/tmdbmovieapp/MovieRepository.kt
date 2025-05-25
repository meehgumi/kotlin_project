package com.example.tmdbmovieapp

class MovieRepository {
    suspend fun getNowPlayingMovies(): List<Movie> {
        return RetrofitInstance.api.getNowPlayingMovies().results
    }

    suspend fun searchMovies(query: String): List<Movie> {
        return RetrofitInstance.api.searchMovies(query = query).results
    }
}
