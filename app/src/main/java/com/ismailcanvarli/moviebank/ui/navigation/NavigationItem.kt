//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Navigasyon öğelerini tanımlar.
 * Her bir öğe, rotası ve başlığıyla birlikte temsil edilir.
 *
 * @param route Rota adı.
 * @param title Navigasyon öğesinin başlığı.
 * @param icon İkon vektörü (null olabilir).
 * @param showInBottomBar Alt navigasyon çubuğunda gösterilip gösterilmeyeceği.
 */
enum class NavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector?,
    val showInBottomBar: Boolean
) {
    Home("homeScreen", "Home", Icons.Default.Home, true),
    Favorites("favoritesScreen", "Favorites", Icons.Default.Favorite, true),
    Cart("movieCartScreen", "Cart", Icons.Default.ShoppingCart, true),
    Details("movieDetailScreen/{movieId}", "Movie Details", null, false)
}