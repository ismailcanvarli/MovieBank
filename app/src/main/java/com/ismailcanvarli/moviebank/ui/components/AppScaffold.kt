//Created by canVarli on 1/10/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ismailcanvarli.moviebank.ui.navigation.NavigationItem

/**
 * Uygulamanın genel iskeletini oluşturan bileşen.
 * Üst ve alt çubukları içerir, belirli rotalara göre alt çubuğu gösterir.
 *
 * @param navController Navigasyon işlemlerini yöneten kontrolör.
 * @param content Scaffold gövdesinde gösterilecek içerik.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(navController = navController)
        },
        bottomBar = {
            if (navController.currentBackStackEntryAsState().value?.destination?.route in
                NavigationItem.entries.filter { it.showInBottomBar }.map { it.route }) {
                BottomBar(navController = navController)
            }
        },
        content = content
    )
}