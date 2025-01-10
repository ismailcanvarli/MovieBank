//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Ana ekranın verilerini yöneten ViewModel.
 * Tüm filmleri getirir ve kullanıcıya sunar.
 *
 * @property repository Filmlerle ilgili işlemleri yöneten repository.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList: StateFlow<List<Movie>> = _movieList

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchMovies()
    }

    /**
     * Tüm filmleri getirir ve listeyi günceller.
     */
    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                repository.getAllMovies().collect { movies ->
                    if (movies.isEmpty()) {
                        _errorMessage.value = "No movies found."
                    } else {
                        _movieList.value = movies
                        _errorMessage.value = null
                    }
                }
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load movies."
            }
        }
    }
}