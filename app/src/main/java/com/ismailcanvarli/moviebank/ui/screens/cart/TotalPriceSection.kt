//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.ui.theme.ButtonColors

/**
 * Sepetin toplam fiyatını ve uygulanan indirimi gösteren bileşen.
 * Kullanıcının sepeti onaylamasına olanak tanır.
 *
 * @param cartMovies Sepetteki filmlerin listesi.
 * @param appliedDiscount Uygulanan indirim yüzdesi.
 * @param onConfirmCart Sepeti onaylama işlemini tetikleyen callback.
 * @param isEnabled Sepetin onaylanabilir olup olmadığını belirleyen değer.
 */
@Composable
fun TotalPriceSection(
    cartMovies: List<MovieCart>,
    appliedDiscount: Int,
    onConfirmCart: () -> Unit,
    isEnabled: Boolean
) {
    val totalPrice = cartMovies.sumOf { it.price * it.orderAmount }.toDouble()
    val discountedPrice = totalPrice - (totalPrice * appliedDiscount / 100)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(R.string.total_price_title),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "$discountedPrice $",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Button(
            onClick = onConfirmCart,
            enabled = isEnabled,
            colors = ButtonColors()
        ) {
            Text(stringResource(R.string.confirm_cart))
        }
    }
}