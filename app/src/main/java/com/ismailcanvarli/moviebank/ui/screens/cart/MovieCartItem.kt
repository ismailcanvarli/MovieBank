//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.MovieCart

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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                    contentDescription = movie.name,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = stringResource(R.string.movie_price, movie.price),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = stringResource(R.string.movie_amount, movie.orderAmount),
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    IconButton(onClick = onIncrement) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_increase),
                            contentDescription = stringResource(R.string.increase_order_amount)
                        )
                    }
                    IconButton(onClick = onDecrement, enabled = movie.orderAmount > 1) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_decrease),
                            contentDescription = stringResource(R.string.decrease_order_amount)
                        )
                    }
                    IconButton(onClick = onRemove) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = stringResource(R.string.remove_all_instances)
                        )
                    }
                }
            }
        }
    }
}