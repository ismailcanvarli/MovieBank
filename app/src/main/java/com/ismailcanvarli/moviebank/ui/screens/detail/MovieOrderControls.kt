//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R

/**
 * Film sipariş miktarını artırma ve azaltma kontrollerini sağlayan bileşen.
 *
 * @param orderAmount Sipariş edilen film adedi.
 * @param onDecrease Sipariş miktarını azaltma işlemini tetikleyen callback.
 * @param onIncrease Sipariş miktarını artırma işlemini tetikleyen callback.
 */
@Composable
fun MovieOrderControls(orderAmount: Int, onDecrease: () -> Unit, onIncrease: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onDecrease,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_decrease),
                contentDescription = "Decrease order amount"
            )
        }
        Text(
            text = "$orderAmount",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleMedium
        )
        IconButton(
            onClick = onIncrease,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_increase),
                contentDescription = "Increase order amount"
            )
        }
    }
}