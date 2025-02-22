//Created by canVarli on 1/10/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.R

/**
 * Film sipariş detaylarını gösteren bileşen.
 *
 * @param moviePrice Film fiyatı.
 * @param orderAmount Sipariş adedi.
 * @param onIncrement Sipariş adedini arttıran fonksiyon.
 * @param onDecrement Sipariş adedini azaltan fonksiyon.
 * @param onAddToCart Sepete ekleme fonksiyonu.
 * @param navController Navigation kontrolcüsü.
 * @param modifier Bileşenin modifikatörü.
 *
 */
@Composable
fun MovieOrderItem(
    moviePrice: Int,
    orderAmount: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onAddToCart: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
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
                text = orderAmount.toString(),
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

            IconButton(onClick = {
                onAddToCart()
                navController.navigate("movieCartScreen")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = stringResource(R.string.add_to_cart_button)
                )
            }
        }
    }
}