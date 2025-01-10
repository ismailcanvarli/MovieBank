//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.repository.FavoritesRepository
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Favoriler ekranını yöneten ViewModel.
 * Kullanıcının favori filmlerini getirir ve favorilerden çıkarma işlemini yönetir.
 *
 * @property favoritesRepository Favori filmlerle ilgili işlemleri yöneten repository.
 */
@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {

    private val _favoriteMovies = MutableStateFlow<List<FavoriteMovieEntity>>(emptyList())
    val favoriteMovies: StateFlow<List<FavoriteMovieEntity>> = _favoriteMovies

    init {
        fetchFavoriteMovies()
    }

    /**
     * Favori filmleri yeniden yükler.
     */
    private fun fetchFavoriteMovies() {
        viewModelScope.launch {
            favoritesRepository.getFavoriteMovies().collect { movies ->
                _favoriteMovies.value = movies
            }
        }
    }

    /**
     * Belirli bir filmi favorilerden çıkarır ve listeyi yeniler.
     *
     * @param movie Favorilerden çıkarılacak film.
     */
    fun removeFavorite(movie: FavoriteMovieEntity) {
        viewModelScope.launch {
            favoritesRepository.deleteFavoriteMovie(movie)
            fetchFavoriteMovies()
        }
    }
}