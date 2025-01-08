//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    val favoriteMovies = repository.getFavoriteMovies()

    fun addFavorite(movie: Movie) {
        viewModelScope.launch {
            repository.addFavorite(movie)
        }
    }

    fun removeFavorite(movie: Movie) {
        viewModelScope.launch {
            repository.removeFavorite(movie)
        }
    }
}
