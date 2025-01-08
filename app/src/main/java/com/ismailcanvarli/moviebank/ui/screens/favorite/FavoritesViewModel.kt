//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.repository.FavoritesRepository
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {

    val favoriteMovies: StateFlow<List<FavoriteMovieEntity>> =
        favoritesRepository.getFavoriteMovies().stateIn(
                viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
            )

    fun addFavorite(movie: FavoriteMovieEntity) {
        viewModelScope.launch {
            favoritesRepository.addFavoriteMovie(movie)
        }
    }

    fun removeFavorite(movie: FavoriteMovieEntity) {
        viewModelScope.launch {
            favoritesRepository.deleteFavoriteMovie(movie)
        }
    }

    fun isFavorite(movieId: Int): Boolean {
        return favoriteMovies.value.any { it.movieId == movieId }
    }
}
