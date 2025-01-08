//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ismailcanvarli.moviebank.ui.screens.home.HomeScreen
import com.ismailcanvarli.moviebank.ui.screens.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route,
        modifier = Modifier.padding(8.dp)
    ) {
        // Home Screen
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }
    }
}