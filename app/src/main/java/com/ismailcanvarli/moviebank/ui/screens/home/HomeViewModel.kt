//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.lifecycle.ViewModel
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}