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
import com.ismailcanvarli.moviebank.R

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

    private val allMovies = mutableListOf<Movie>()
    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList: StateFlow<List<Movie>> = _movieList

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory

    val sortOptions = mapOf(
        "NAME_ASC" to R.string.sort_name_asc,
        "NAME_DESC" to R.string.sort_name_desc,
        "RATING_HIGH" to R.string.sort_rating_high,
        "RATING_LOW" to R.string.sort_rating_low,
        "PRICE_LOW" to R.string.sort_price_low,
        "PRICE_HIGH" to R.string.sort_price_high
    )

    val categories = mapOf(
        "All" to R.string.category_all,
        "Action" to R.string.category_action,
        "Comedy" to R.string.category_comedy,
        "Drama" to R.string.category_drama,
        "Horror" to R.string.category_horror,
        "Sci-Fi" to R.string.category_scifi,
        "Romance" to R.string.category_romance,
        "Thriller" to R.string.category_thriller,
        "Fantastic" to R.string.category_fantastic
    )

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
                applyFilters()
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
     * Kategoriye göre filmleri filtreler.
     *
     * @param category Kategori.
     */
    fun updateCategory(category: String) {
        _selectedCategory.value = category
        applyFilters()
    }

    /**
     * Arama sorgusuna göre filmleri filtreler.
     */
    private fun applyFilters() {
        val query = _searchQuery.value.lowercase()
        val category = _selectedCategory.value

        _movieList.value = allMovies.filter { movie ->
            val normalizedCategory = when (movie.category.lowercase()) {
                "science fiction" -> "Sci-Fi"
                else -> movie.category
            }

            val matchesCategory = category == "All" || normalizedCategory.equals(category, ignoreCase = true)
            val matchesQuery = query.isEmpty() ||
                    movie.name.lowercase().contains(query) ||
                    movie.director.lowercase().contains(query)

            matchesCategory && matchesQuery
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