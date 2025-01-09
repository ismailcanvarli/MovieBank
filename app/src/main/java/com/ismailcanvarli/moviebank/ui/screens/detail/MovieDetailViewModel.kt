//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.repository.FavoritesRepository
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository,
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _isFavorite = MutableStateFlow(false)
    private val _addToCartMessage = MutableStateFlow<String?>(null)
    val isFavorite: StateFlow<Boolean> = _isFavorite

    fun checkIfFavorite(movieId: Int) {
        viewModelScope.launch {
            _isFavorite.value = favoritesRepository.isMovieFavorite(movieId)
        }
    }

    fun toggleFavorite(movie: FavoriteMovieEntity) {
        viewModelScope.launch {
            if (_isFavorite.value) {
                favoritesRepository.deleteFavoriteMovie(movie)
            } else {
                favoritesRepository.addFavoriteMovie(movie)
            }
            _isFavorite.value = !_isFavorite.value
        }
    }

    fun addMovieToCart(movie: Movie, userName: String, orderAmount: Int) {
        viewModelScope.launch {
            val response = movieRepository.addMovieToCart(movie, orderAmount, userName)
            _addToCartMessage.value = response.message
        }
    }
}