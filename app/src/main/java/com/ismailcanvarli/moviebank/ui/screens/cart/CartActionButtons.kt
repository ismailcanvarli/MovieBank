//Created by canVarli on 1/11/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Column
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
 *
 */
@Composable
fun CartActionButtons(
    orderAmount: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onRemove: () -> Unit,
    isDecrementEnabled: Boolean = true
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Artırma butonu
        IconButton(onClick = onIncrement, modifier = Modifier.padding(bottom = 4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_increase),
                contentDescription = stringResource(R.string.increase_order_amount)
            )
        }

        // Sipariş adedi
        Text(
            text = orderAmount.toString(),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 2.dp) // Boşluk azaltıldı
        )

        // Azaltma butonu
        IconButton(onClick = onDecrement, enabled = isDecrementEnabled, modifier = Modifier.padding(top = 4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_decrease),
                contentDescription = stringResource(R.string.decrease_order_amount)
            )
        }

        // Silme butonu
        IconButton(onClick = onRemove, modifier = Modifier.padding(top = 4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = stringResource(R.string.remove_all_instances)
            )
        }
    }
}