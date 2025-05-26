package com.example.tmdbmovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.tmdbmovieapp.ui.theme.TMDBMovieAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBMovieAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Text(
                                text = "Menu",
                                style = MaterialTheme.typography.titleLarge,
                            )
                            NavigationDrawerItem(
                                label = { Text("Accueil") },
                                selected = false,
                                onClick = {
                                    navController.navigate("home")
                                    scope.launch { drawerState.close() }
                                }
                            )
                            NavigationDrawerItem(
                                label = { Text("Paramètres") },
                                selected = false,
                                onClick = {
                                    navController.navigate("settings")
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    }
                ) {
                    @OptIn(ExperimentalMaterial3Api::class)
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("TMDB Movie App") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            if (drawerState.isClosed) drawerState.open()
                                            else drawerState.close()
                                        }
                                    }) {
                                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                                    }
                                }
                            )
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "home",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("home") { HomeScreen() }
                        }
                    }
                }
            }
        }
    }
}