//Created by canVarli on 1/11/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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

/**
 * Kullanıcının sepetindeki bir film öğesini temsil eden bileşen.
 * Kullanıcı, sipariş miktarını artırabilir, azaltabilir veya tamamen kaldırabilir.
 *
 * @param orderAmount Sipariş miktarı.
 * @param onIncrement Sipariş miktarını arttıran fonksiyon.
 * @param onDecrement Sipariş miktarını azaltan fonksiyon.
 * @param onRemove Film öğesini tamamen kaldıran fonksiyon.
 * @param isDecrementEnabled Sipariş miktarını azaltma butonunun etkin olup olmadığını belirten değer.
 */
@Composable
fun CartActionButtons(
    orderAmount: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onRemove: () -> Unit,
    isDecrementEnabled: Boolean = true
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        IconButton(onClick = onDecrement, enabled = isDecrementEnabled) {
            Icon(
                painter = painterResource(id = R.drawable.ic_decrease),
                contentDescription = stringResource(R.string.decrease_order_amount)
            )
        }

        Text(
            text = orderAmount.toString(),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        IconButton(onClick = onIncrement) {
            Icon(
                painter = painterResource(id = R.drawable.ic_increase),
                contentDescription = stringResource(R.string.increase_order_amount)
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