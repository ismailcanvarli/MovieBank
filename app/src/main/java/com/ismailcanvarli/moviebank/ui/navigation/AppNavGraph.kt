//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.ui.screens.cart.MovieCartScreen
import com.ismailcanvarli.moviebank.ui.screens.cart.MovieCartViewModel
import com.ismailcanvarli.moviebank.ui.screens.detail.MovieDetailScreen
import com.ismailcanvarli.moviebank.ui.screens.detail.MovieDetailViewModel
import com.ismailcanvarli.moviebank.ui.screens.favorite.FavoritesScreen
import com.ismailcanvarli.moviebank.ui.screens.favorite.FavoritesViewModel
import com.ismailcanvarli.moviebank.ui.screens.home.HomeScreen
import com.ismailcanvarli.moviebank.ui.screens.home.HomeViewModel
import com.ismailcanvarli.moviebank.ui.screens.splash.SplashScreen

/**
 * Uygulamanın navigasyon yapısını tanımlar.
 * Farklı ekranlar arasında geçiş yapılmasını sağlar.
 *
 * @param homeViewModel Ana ekran için kullanılan ViewModel.
 */
@Composable
fun AppNavGraph(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    AppScaffold(navController = navController) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavigationItem.Splash.route) {
                SplashScreen(
                    navigateToHome = {
                        navController.navigate(NavigationItem.Home.route) {
                            popUpTo(NavigationItem.Splash.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(NavigationItem.Home.route) {
                HomeScreen(navController = navController, viewModel = homeViewModel)
            }
            composable(NavigationItem.Favorites.route) {
                val favoritesViewModel: FavoritesViewModel = hiltViewModel()
                FavoritesScreen(navController = navController, viewModel = favoritesViewModel)
            }
            composable(NavigationItem.Cart.route) {
                val movieCartViewModel: MovieCartViewModel = hiltViewModel()
                MovieCartScreen(viewModel = movieCartViewModel)
            }
            composable(
                NavigationItem.Details.route,
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt("movieId")
                val movieList by homeViewModel.movieList.collectAsState()
                val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()

                val selectedMovie = movieList.find { it.id == movieId }

                selectedMovie?.let {
                    MovieDetailScreen(
                        movie = it,
                        viewModel = movieDetailViewModel,
                        navController = navController
                    )
                } ?: Text(stringResource(R.string.movie_not_found))
            }
        }
    }
}