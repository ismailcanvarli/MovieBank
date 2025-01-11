//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.model.toMovie
import com.ismailcanvarli.moviebank.ui.components.MovieCard

/**
 * Kullanıcının sepetindeki bir film öğesini temsil eden bileşen.
 * Kullanıcı, sipariş miktarını artırabilir, azaltabilir veya tamamen kaldırabilir.
 *
 * @param movie Gösterilecek film bilgisi.
 * @param onIncrement Sipariş miktarını artırma işlemini tetikleyen callback.
 * @param onDecrement Sipariş miktarını azaltma işlemini tetikleyen callback.
 * @param onRemove Film öğesini tamamen kaldırma işlemini tetikleyen callback.
 */
@Composable
fun MovieCartItem(
    movie: MovieCart,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onRemove: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieCard(movie = movie.toMovie(), onClick = {}, actionButton = {
            CartActionButtons(
                orderAmount = movie.orderAmount,
                onIncrement = onIncrement,
                onDecrement = onDecrement,
                onRemove = onRemove,
                isDecrementEnabled = movie.orderAmount > 1
            )
        })
    }
}