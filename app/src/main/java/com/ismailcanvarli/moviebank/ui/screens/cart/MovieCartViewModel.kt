//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.model.toMovie
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Kullanıcının sepet verilerini yöneten ViewModel.
 * Sepetteki filmleri getirir, düzenler ve silme işlemlerini yönetir.
 *
 * @property repository Film ve sepet işlemleri için kullanılan repository.
 */
@HiltViewModel
class MovieCartViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _cartMovies = MutableStateFlow<List<MovieCart>>(emptyList())
    val cartMovies: StateFlow<List<MovieCart>> = _cartMovies

    /**
     * Belirtilen kullanıcının sepetindeki filmleri getirir.
     * Aynı isimdeki filmleri birleştirerek miktarları toplar.
     *
     * @param userName Kullanıcı adı.
     */
    fun fetchCartMovies(userName: String) {
        viewModelScope.launch {
            try {
                val movies = repository.getCartMovies(userName)

                val groupedMovies = movies.groupBy { it.name }.map { (_, movieList) ->
                    movieList.reduce { acc, movie ->
                        acc.copy(orderAmount = acc.orderAmount + movie.orderAmount)
                    }
                }

                _cartMovies.value = groupedMovies
            } catch (e: Exception) {
                Log.e("MovieCartViewModel", "Error fetching cart movies: ${e.message}")
                _cartMovies.value = emptyList()
            }
        }
    }

    /**
     * Belirli bir filmin tüm örneklerini sepetten siler.
     *
     * @param movieName Silinecek filmin adı.
     * @param userName Kullanıcı adı.
     */
    fun deleteAllInstancesOfMovie(movieName: String, userName: String) {
        viewModelScope.launch {
            try {
                val moviesToDelete = repository.getCartMovies(userName).filter { it.name == movieName }

                moviesToDelete.forEach { movie ->
                    repository.deleteMovieFromCart(movie.cartId, userName)
                }

                fetchCartMovies(userName)
            } catch (e: Exception) {
                Log.e("MovieCartViewModel", "Error deleting movies: ${e.message}")
            }
        }
    }

    /**
     * Sepetteki filmin miktarını artırır.
     *
     * @param movie Miktarı artırılacak film.
     */
    fun incrementMovieAmount(movie: MovieCart) {
        viewModelScope.launch {
            repository.addMovieToCart(
                movie = movie.toMovie(), orderAmount = 1, userName = Constants.USER_NAME
            )
            fetchCartMovies(Constants.USER_NAME)
        }
    }

    /**
     * Sepetteki filmin miktarını azaltır.
     * Miktar 1'in altına düşemez.
     *
     * @param movie Miktarı azaltılacak film.
     */
    fun decrementMovieAmount(movie: MovieCart) {
        if (movie.orderAmount > 1) {
            viewModelScope.launch {
                repository.addMovieToCart(
                    movie = movie.toMovie(), orderAmount = -1, userName = Constants.USER_NAME
                )
                fetchCartMovies(Constants.USER_NAME)
            }
        }
    }
}