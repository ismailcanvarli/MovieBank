//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.ui.component.MovieRow
import com.ismailcanvarli.moviebank.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController, homeViewModel: HomeViewModel
) {
    val movieList = homeViewModel.movieList.observeAsState(listOf())

    LaunchedEffect(key1 = true) {
        homeViewModel.getAllMovies()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(count = movieList.value.size) { index ->
            val movie = movieList.value[index]
            MovieRow(movie = movie, onMovieClick = {
                navController.navigate("movieDetailScreen/${movie.id}")
            })
        }
    }
}