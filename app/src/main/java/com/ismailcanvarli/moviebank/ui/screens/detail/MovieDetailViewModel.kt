//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _movieDetail = MutableLiveData<Movie>()
    val movieDetail: LiveData<Movie> = _movieDetail


    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            if (movie.isFavorite) {
                repository.removeFavorite(movie)
            } else {
                repository.addFavorite(movie)
            }
        }
    }
}
