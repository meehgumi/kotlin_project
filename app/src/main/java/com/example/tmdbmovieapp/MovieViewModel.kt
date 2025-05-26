package com.example.tmdbmovieapp

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()
    var movieList by mutableStateOf<List<Movie>>(listOf())
        private set

    var searchQuery by mutableStateOf("")
        private set

    init {
        fetchNowPlayingMovies()
    }

    private fun fetchNowPlayingMovies() {
        viewModelScope.launch {
            movieList = repository.getNowPlayingMovies()
        }
    }

    fun onSearchQueryChange(query: String) {
        searchQuery = query
        viewModelScope.launch {
            movieList = if (query.isEmpty()) {
                repository.getNowPlayingMovies()
            } else {
                repository.searchMovies(query)
            }
        }
    }
}
