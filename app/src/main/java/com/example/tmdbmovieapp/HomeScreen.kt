package com.example.tmdbmovieapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tmdbmovieapp.MovieItem

@Composable
fun HomeScreen() {
    val viewModel: MovieViewModel = viewModel()
    val movies by remember { derivedStateOf { viewModel.movieList } }
    val searchQuery by remember { derivedStateOf { viewModel.searchQuery } }
    var selectedMovie by remember { mutableStateOf<Movie?>(null) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.onSearchQueryChange(it) },
            label = { Text("Rechercher un film") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(movies) { movie ->
                MovieItem(movie = movie) { selectedMovie = it }
            }
        }
    }

    selectedMovie?.let { movie ->
        AlertDialog(
            onDismissRequest = { selectedMovie = null },
            title = { Text(text = movie.title ?: "Titre inconnu") },
            text = { Text(text = movie.overview ?: "Aucun résumé disponible.") },
            confirmButton = {
                TextButton(onClick = { selectedMovie = null }) {
                    Text("Fermer")
                }
            }
        )
    }
}