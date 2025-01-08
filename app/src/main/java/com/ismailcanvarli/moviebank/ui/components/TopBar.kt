//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.ui.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route
    val currentItem = NavigationItem.entries.find { currentRoute?.startsWith(it.route) == true }
    val title = currentItem?.title ?: "Movie Bank"
    val canNavigateBack =
        navController.previousBackStackEntry != null && currentRoute != NavigationItem.Home.route // Ana sayfadaysak geri butonu gösterme

    CenterAlignedTopAppBar(title = { Text(text = title) }, navigationIcon = {
        if (canNavigateBack) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Back"
                )
            }
        }
    })
}