//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddToCartButton(orderAmount: Int, onAddToCart: () -> Unit) {
    Button(
        onClick = onAddToCart, modifier = Modifier.fillMaxWidth()
    ) {
        Text("Add $orderAmount to Cart")
    }
}