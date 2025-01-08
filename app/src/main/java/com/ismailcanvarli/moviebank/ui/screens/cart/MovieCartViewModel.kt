//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.model.CrudResponse
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieCartViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _cartMovies = MutableStateFlow<List<MovieCart>>(emptyList())
    private val _deleteResponse = MutableStateFlow<CrudResponse?>(null)
    val cartMovies: StateFlow<List<MovieCart>> = _cartMovies

    fun fetchCartMovies(userName: String) {
        viewModelScope.launch {
            try {
                Log.d("MovieCartScreen", "Fetching cart movies for user: $userName")
                val movies = repository.getCartMovies(userName)
                Log.d("MovieCartScreen", "Received movies: $movies")
                _cartMovies.value = movies
            } catch (e: Exception) {
                Log.e("MovieCartScreen", "Error fetching cart movies: ${e.message}")
                _cartMovies.value = emptyList()
            }
        }
    }

    fun deleteMovieFromCart(cartId: Int, userName: String) {
        viewModelScope.launch {
            val response = repository.deleteMovieFromCart(cartId, userName)
            _deleteResponse.value = response
            fetchCartMovies(userName)
        }
    }
}