//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String, navController: NavController
) {
    val canNavigateBack = navController.previousBackStackEntry != null // Önceki ekran var mı?

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