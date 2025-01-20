package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.MovieCart

/**
 * Kullanıcının sepetindeki bir film öğesini temsil eden bileşen.
 *
 * @param movie Gösterilecek film bilgisi.
 * @param onIncrement Sipariş miktarını artırma işlemini tetikleyen callback.
 * @param onDecrement Sipariş miktarını azaltma işlemini tetikleyen callback.
 * @param onRemove Film öğesini tamamen kaldırma işlemini tetikleyen callback.
 */
@Composable
fun CartItemCard(
    movie: MovieCart,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                    contentDescription = movie.name,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Price: ${movie.price}$",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    CartActionButtons(
                        orderAmount = movie.orderAmount,
                        onIncrement = onIncrement,
                        onDecrement = onDecrement,
                        onRemove = onRemove,
                        isDecrementEnabled = movie.orderAmount > 1
                    )
                }
            }
        }
    }
}