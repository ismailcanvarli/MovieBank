//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.screens.favorite


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.data.room.toMovie
import com.ismailcanvarli.moviebank.ui.components.MovieCard
import com.ismailcanvarli.moviebank.ui.screens.detail.AddToFavoriteButton

/**
 * Kullanıcının favori filmlerini listeleyen ekran.
 * Filmlerin detay sayfasına geçiş yapabilir veya favorilerden çıkarabilir.
 *
 * @param viewModel Favori filmleri yöneten ViewModel.
 * @param navController Navigasyon işlemlerini yöneten kontrolör.
 */
@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel, navController: NavController
) {
    val favoriteMovies by viewModel.favoriteMovies.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteMovies) { favoriteMovie ->
            val movie = favoriteMovie.toMovie()
            MovieCard(movie = movie,
                onClick = { navController.navigate("movieDetailScreen/${movie.id}") },
                actionButton = {
                    AddToFavoriteButton(isFavorite = true,
                        onToggleFavorite = { viewModel.removeFavorite(favoriteMovie) })
                })
        }
    }
}