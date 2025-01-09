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

    init {
        fetchMovies()
    }

    /**
     * Tüm filmleri getirir ve listeyi günceller.
     */
    private fun fetchMovies() {
        viewModelScope.launch {
            repository.getAllMovies().collect { movies ->
                _movieList.value = movies
            }
        }
    }
}