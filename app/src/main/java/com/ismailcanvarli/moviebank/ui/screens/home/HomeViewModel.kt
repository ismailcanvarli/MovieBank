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

    private val allMovies = mutableListOf<Movie>() // Tüm filmleri tutar
    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList: StateFlow<List<Movie>> = _movieList

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        fetchMovies()
    }

    /**
     * Tüm filmleri yeniden yükler.
     */
    private fun fetchMovies() {
        viewModelScope.launch {
            repository.getAllMovies().collect { movies ->
                allMovies.clear()
                allMovies.addAll(movies)
                _movieList.value = movies
                _errorMessage.value = null
            }
        }
    }

    /**
     * Arama sorgusunu günceller ve filtre uygular.
     *
     * @param query Arama sorgusu.
     */
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        applyFilters()
    }

    /**
     * Arama sorgusuna göre filmleri filtreler.
     */
    private fun applyFilters() {
        val query = _searchQuery.value.lowercase()
        _movieList.value = if (query.isEmpty()) {
            allMovies
        } else {
            allMovies.filter {
                it.name.lowercase().contains(query) || it.director.lowercase().contains(query)
            }
        }
    }

    /**
     * Sıralama seçeneğine göre filmleri sıralar.
     *
     * @param optionKey Sıralama seçeneği.
     */
    fun updateSortOption(optionKey: String) {
        _movieList.value = when (optionKey) {
            "NAME_ASC" -> _movieList.value.sortedBy { it.name }
            "NAME_DESC" -> _movieList.value.sortedByDescending { it.name }
            "RATING_HIGH" -> _movieList.value.sortedByDescending { it.rating }
            "RATING_LOW" -> _movieList.value.sortedBy { it.rating }
            "PRICE_LOW" -> _movieList.value.sortedBy { it.price }
            "PRICE_HIGH" -> _movieList.value.sortedByDescending { it.price }
            else -> _movieList.value
        }
    }
}