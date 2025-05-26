# TMDB Movie App

## Membres du binôme

- Mehdi-Paul BRUNET, Ilies BOUDHAN, Aurélien BOUQUILLON

## Sujet du projet

Application Android utilisant Jetpack Compose pour rechercher et afficher des films depuis l'API TMDB.

## Description du projet

Cette application mobile Kotlin utilise l’API de **The Movie Database (TMDB)** pour permettre à l’utilisateur :
- de rechercher des films via un champ de recherche,
- de consulter les résultats sous forme de liste,
- d’afficher l’affiche, le titre, la date de sortie et le résumé de chaque film.

Le tout est développé avec **Jetpack Compose** et suit une architecture **MVVM** pour la séparation des responsabilités.

## Informations supplémentaires

- **API REST utilisée** : [TMDB API](https://developer.themoviedb.org/)
- **Pour instancier l’API TMDB**, il faut :
  1. Obtenir une clé API sur le site TMDB.
  2. La placer dans une constante ou un fichier sécurisé (ex : `Constants.kt`).
  3. Utiliser Retrofit pour les appels réseau.

### Problèmes rencontrés

- Erreurs de compilation liées à des imports manquants (`viewModel()`, `rememberAsyncImagePainter`).
- Problèmes de configuration `AndroidManifest.xml` avec `package`.
- Problèmes d'import
