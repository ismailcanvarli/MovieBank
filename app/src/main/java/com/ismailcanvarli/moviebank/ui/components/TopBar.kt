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

/**
 * Uygulamanın üst navigasyon çubuğunu oluşturur.
 * Ekrana özel başlıkları ve geri dönüş işlemini yönetir.
 *
 * @param navController Navigasyon işlemlerini yöneten kontrolör.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    CenterAlignedTopAppBar(title = {
            Text(
                text = when (currentRoute) {
                    NavigationItem.Home.route -> "Home"
                    NavigationItem.Favorites.route -> "Favorites"
                    NavigationItem.Cart.route -> "Cart"
                    NavigationItem.Details.route -> "Details"
                    else -> "Movie Bank"
                }
            )
        },
        navigationIcon = {
            if (currentRoute == NavigationItem.Details.route) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}