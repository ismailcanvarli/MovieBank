package com.ismailcanvarli.moviebank.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Uygulamanın alt navigasyon çubuğunu oluşturur.
 * Kullanıcının belirli ekranlara hızlıca erişmesini sağlar.
 *
 * @param navController Navigasyon işlemlerini yöneten kontrolör.
 */
@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationItem.entries.forEach { item ->
            NavigationBarItem(
                icon = {
                    item.icon?.let {
                        Icon(imageVector = it, contentDescription = stringResource(item.titleResId))
                    }
                },
                label = { Text(stringResource(item.titleResId)) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}