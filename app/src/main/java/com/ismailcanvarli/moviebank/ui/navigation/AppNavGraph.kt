//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.navigation

// Compose Temel Bileşenler

// Navigation Kütüphaneleri

// Proje İçindeki Custom Sınıflar ve Bileşenler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ismailcanvarli.moviebank.ui.components.BottomBar
import com.ismailcanvarli.moviebank.ui.components.TopBar
import com.ismailcanvarli.moviebank.ui.screens.cart.MovieCartScreen
import com.ismailcanvarli.moviebank.ui.screens.cart.MovieCartViewModel
import com.ismailcanvarli.moviebank.ui.screens.detail.MovieDetailScreen
import com.ismailcanvarli.moviebank.ui.screens.detail.MovieDetailViewModel
import com.ismailcanvarli.moviebank.ui.screens.favorite.FavoritesScreen
import com.ismailcanvarli.moviebank.ui.screens.favorite.FavoritesViewModel
import com.ismailcanvarli.moviebank.ui.screens.home.HomeScreen
import com.ismailcanvarli.moviebank.ui.screens.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    Scaffold(topBar = {
        TopBar(navController = navController)
    }, bottomBar = {
        if (navController.currentBackStackEntryAsState().value?.destination?.route in NavigationItem.entries.filter { it.showInBottomBar }
                .map { it.route }) {
            BottomBar(navController = navController)
        }
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Home Screen
            composable(NavigationItem.Home.route) {
                HomeScreen(navController = navController, viewModel = homeViewModel)
            }

            // Favorites Screen
            composable(NavigationItem.Favorites.route) {
                val favoritesViewModel: FavoritesViewModel = hiltViewModel()
                FavoritesScreen(viewModel = favoritesViewModel)
            }
            // Cart Screen
            composable(NavigationItem.Cart.route) {
                val movieCartViewModel: MovieCartViewModel = hiltViewModel()
                MovieCartScreen(
                    navController = navController, movieCartViewModel = movieCartViewModel
                )
            }

            // Movie Detail Screen
            composable(
                NavigationItem.Details.route,
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt("movieId")
                val movieList by homeViewModel.movieList.collectAsState() // collectAsState kullanımı
                val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()

                val selectedMovie = movieList.find { it.id == movieId } // movieId ile filmi bulma

                selectedMovie?.let {
                    MovieDetailScreen(movie = it, viewModel = movieDetailViewModel)
                } ?: Text("Movie not found")
            }

        }
    }
}