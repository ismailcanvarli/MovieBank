//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ismailcanvarli.moviebank.ui.component.BottomBar
import com.ismailcanvarli.moviebank.ui.component.TopBar
import com.ismailcanvarli.moviebank.ui.screen.HomeScreen
import com.ismailcanvarli.moviebank.ui.screen.MovieCartScreen
import com.ismailcanvarli.moviebank.ui.screen.MovieDetailScreen
import com.ismailcanvarli.moviebank.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            val currentRoute = navController.currentDestination?.route ?: "Home"
            TopBar(
                title = when (currentRoute) {
                    "homeScreen" -> "Home"
                    "movieDetailScreen/{movieId}" -> "Movie Details"
                    "movieCartScreen" -> "Cart"
                    else -> "Movie Bank"
                },
                navController = navController
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "homeScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("homeScreen") {
                HomeScreen(navController = navController, homeViewModel = homeViewModel)
            }
            composable(
                route = "movieDetailScreen/{movieId}",
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt("movieId")
                val selectedMovie = homeViewModel.movieList.value?.find { it.id == movieId }
                MovieDetailScreen(movie = selectedMovie)
            }
            composable("movieCartScreen") {
                MovieCartScreen()
            }
        }
    }
}