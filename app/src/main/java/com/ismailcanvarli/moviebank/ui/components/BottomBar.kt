//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ismailcanvarli.moviebank.ui.navigation.NavigationItem

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationItem.entries.filter { it.showInBottomBar }.forEach { item ->
            NavigationBarItem(icon = {
                Icon(
                    imageVector = item.icon!!, contentDescription = item.title
                )
            }, label = { Text(item.title) }, selected = currentRoute == item.route, onClick = {
                if (currentRoute != item.route) {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            })
        }
    }
}