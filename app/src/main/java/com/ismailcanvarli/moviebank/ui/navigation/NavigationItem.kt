//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.ismailcanvarli.moviebank.R

/**
 * Navigasyon öğelerini tanımlar.
 * Her bir öğe, rotası ve başlığıyla birlikte temsil edilir.
 *
 * @param route Rota adı.
 * @param icon İkon vektörü (null olabilir).
 * @param showInBottomBar Alt navigasyon çubuğunda gösterilip gösterilmeyeceği.
 * @param titleResId Başlık kaynağı ID'si.
 */
sealed class NavigationItem(
    val route: String,
    val icon: ImageVector?,
    val showInBottomBar: Boolean,
    val titleResId: Int
) {
    object Home : NavigationItem("homeScreen", Icons.Default.Home, true, R.string.home_title)
    object Favorites : NavigationItem("favoritesScreen", Icons.Default.Favorite, true, R.string.favorites_title)
    object Cart : NavigationItem("movieCartScreen", Icons.Default.ShoppingCart, true, R.string.cart_title)
    object Details : NavigationItem("movieDetailScreen/{movieId}", null, false, R.string.details_title)
    object Splash : NavigationItem("splashScreen", null, false, R.string.splash_title)

    companion object {
        val entries = listOf(Home, Favorites, Cart)
    }
}