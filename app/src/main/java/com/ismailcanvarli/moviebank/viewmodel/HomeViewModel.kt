//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ismailcanvarli.moviebank.data.entity.Movie
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val movieRepository: MovieRepository
) : ViewModel() {
    var movieList = MutableLiveData<List<Movie>>()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        CoroutineScope(Dispatchers.Main).launch {
            movieList.value = movieRepository.getAllMovies()
        }
    }
}
