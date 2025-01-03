//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.viewmodel

import androidx.lifecycle.ViewModel
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieCartViewModel @Inject constructor(
    var movieRepository: MovieRepository
): ViewModel() {

}