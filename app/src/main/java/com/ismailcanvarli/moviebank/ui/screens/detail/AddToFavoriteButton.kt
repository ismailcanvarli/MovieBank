//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R

/**
 * Bir filmi favorilere eklemek için kullanılan buton bileşeni.
 *
 * @param isFavorite Film favorilere ekli mi?
 * @param onToggleFavorite Favori durumunu değiştiren fonksiyon.
 */
@Composable
fun AddToFavoriteButton(
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onToggleFavorite,
        modifier = modifier.size(48.dp)
    ) {
        Icon(
            painter = painterResource(
                id = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_empty
            ),
            contentDescription = if (isFavorite) {
                stringResource(R.string.remove_from_favorites)
            } else {
                stringResource(R.string.add_to_favorites)
            }
        )
    }
}