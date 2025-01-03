package com.ismailcanvarli.moviebank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.ismailcanvarli.moviebank.navigation.AppNavGraph
import com.ismailcanvarli.moviebank.ui.theme.MovieBankTheme
import com.ismailcanvarli.moviebank.viewmodel.HomeViewModel
import com.ismailcanvarli.moviebank.viewmodel.MovieCartViewModel
import com.ismailcanvarli.moviebank.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val homeViewModel: HomeViewModel by viewModels()
    val movieDetailViewModel: MovieDetailViewModel by viewModels()
    val movieCartViewModel: MovieCartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieBankTheme {
                AppNavGraph(homeViewModel, movieDetailViewModel, movieCartViewModel)
            }
        }
    }
}