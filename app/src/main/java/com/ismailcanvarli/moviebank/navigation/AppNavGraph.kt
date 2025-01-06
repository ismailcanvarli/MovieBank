//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ismailcanvarli.moviebank.ui.screen.HomeScreen
import com.ismailcanvarli.moviebank.viewmodel.HomeViewModel

@Composable
fun AppNavGraph(
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                navController = navController, homeViewModel = homeViewModel
            )
        }
    }
}