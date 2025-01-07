//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationItem(val route: String, val title: String, val icon: ImageVector?, val showInBottomBar: Boolean) {
    Home("homeScreen", "Home", Icons.Default.Home, true),
    Cart("movieCartScreen", "Cart", Icons.Default.ShoppingCart, true),
    Details("movieDetailScreen/{movieId}", "Movie Details", null, false) // BottomBar'da görünmeyecek
}