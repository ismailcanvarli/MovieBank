//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoriteToggleButton(isFavorite: Boolean, onToggleFavorite: () -> Unit) {
    Button(
        onClick = onToggleFavorite, modifier = Modifier.fillMaxWidth()
    ) {
        Text(if (isFavorite) "Remove from Favorites" else "Add to Favorites")
    }
}