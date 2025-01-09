//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoriteButton(onAddToFavorite: () -> Unit) {
    Button(
        onClick = onAddToFavorite,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Add to Favorites")
    }
}