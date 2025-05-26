package com.example.tmdbmovieapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Crédits") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Cette application, créée par Mehdi, Ilies et Aurélien, est un outil de recherche de films. Elle utilise une API régulièrement mise à jour dès la sortie de nouveaux films. L'application permet ainsi de consulter les derniers films sortis ou de rechercher un film spécifique pour en lire le résumé",
                textAlign = TextAlign.Center
            )
        }
    }
}