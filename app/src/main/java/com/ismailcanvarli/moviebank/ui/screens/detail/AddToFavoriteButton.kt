//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R

/**
 * Bir filmi favorilere eklemek için kullanılan buton bileşeni.
 *
 * @param isFavorite Film favorilere ekli mi?
 * @param onToggleFavorite Favori durumunu değiştiren fonksiyon.
 * @param modifier Bileşenin modifikatörü.
 */
@Composable
fun AddToFavoriteButton(
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
    ) {
        androidx.compose.foundation.Canvas(
            modifier = Modifier.matchParentSize()
        ) {
            drawCircle(
                color = Color.Red,
                radius = size.minDimension / 2
            )
        }

        IconButton(
            onClick = onToggleFavorite,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                painter = painterResource(
                    id = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_empty
                ),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}