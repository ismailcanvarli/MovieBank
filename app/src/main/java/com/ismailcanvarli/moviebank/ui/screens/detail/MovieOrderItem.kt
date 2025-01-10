//Created by canVarli on 1/10/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R

@Composable
fun MovieOrderItem(
    moviePrice: Int,
    orderAmount: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.movie_price, moviePrice),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = onDecrement,
                enabled = orderAmount > 1
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_decrease),
                    contentDescription = stringResource(R.string.decrease_order_amount)
                )
            }

            Text(
                text = stringResource(R.string.movie_amount, orderAmount),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            IconButton(onClick = onIncrement) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_increase),
                    contentDescription = stringResource(R.string.increase_order_amount)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = onAddToCart) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = stringResource(R.string.add_to_cart_button)
                )
            }
        }
    }
}