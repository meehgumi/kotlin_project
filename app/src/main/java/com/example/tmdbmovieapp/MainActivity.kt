package com.example.tmdbmovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.tmdbmovieapp.ui.theme.TMDBMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBMovieAppTheme {
                val viewModel: MovieViewModel = viewModel()
                val movies by remember { derivedStateOf { viewModel.movieList } }
                val searchQuery by remember { derivedStateOf { viewModel.searchQuery } }
                var selectedMovie by remember { mutableStateOf<Movie?>(null) }

                Column(
                    modifier = Modifier
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
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick(movie) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${movie.poster_path}"),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = movie.title ?: "Titre inconnu",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = movie.release_date ?: "Date inconnue",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}