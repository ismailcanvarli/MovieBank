package com.ismailcanvarli.moviebank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.ismailcanvarli.moviebank.ui.navigation.AppNavGraph
import com.ismailcanvarli.moviebank.ui.theme.MovieBankTheme
import com.ismailcanvarli.moviebank.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieBankTheme {
                AppNavGraph(homeViewModel)
            }
        }
    }
}