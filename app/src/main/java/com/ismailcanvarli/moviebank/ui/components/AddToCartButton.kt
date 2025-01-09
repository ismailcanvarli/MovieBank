//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ismailcanvarli.moviebank.R

/**
 * Sepete film ekleme işlemini gerçekleştiren buton bileşeni.
 * Sipariş miktarını gösterir ve ekleme işlemini tetikler.
 *
 * @param orderAmount Sipariş edilen film adedi.
 * @param onAddToCart Sepete ekleme işlemini tetikleyen callback.
 */
@Composable
fun AddToCartButton(orderAmount: Int, onAddToCart: () -> Unit) {
    Button(
        onClick = onAddToCart,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.add_to_cart, orderAmount)
        )
    }
}