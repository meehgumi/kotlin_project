package com.example.tmdbmovieapp

class MovieRepository {
    suspend fun getNowPlayingMovies(): List<Movie> {
        return try {
            RetrofitInstance.api.getNowPlayingMovies().results
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun searchMovies(query: String): List<Movie> {
        return try {
            RetrofitInstance.api.searchMovies(query).results
        } catch (e: Exception) {
            emptyList()
        }
    }
}