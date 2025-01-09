//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ismailcanvarli.moviebank.R

/**
 * Bir filmi favorilere eklemek için kullanılan buton bileşeni.
 *
 * @param onAddToFavorite Favorilere ekleme işlemini tetikleyen callback.
 */
@Composable
fun FavoriteButton(onAddToFavorite: () -> Unit) {
    Button(
        onClick = onAddToFavorite,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.add_to_favorites))
    }
}