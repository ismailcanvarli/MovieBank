//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismailcanvarli.moviebank.data.entity.Movie
import com.ismailcanvarli.moviebank.data.repository.RemoteMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RemoteMovieRepository
) : ViewModel() {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    fun getAllMovies() {
        viewModelScope.launch {
            val movies = repository.getAllMovies()
            _movieList.postValue(movies)
        }
    }
}