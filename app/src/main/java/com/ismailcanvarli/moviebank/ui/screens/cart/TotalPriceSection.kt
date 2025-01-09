//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.data.model.MovieCart

@Composable
fun TotalPriceSection(
    cartMovies: List<MovieCart>,
    appliedDiscount: Int,
    onConfirmCart: () -> Unit
) {
    val totalPrice = cartMovies.sumOf { it.price * it.orderAmount }
    val discountedPrice = totalPrice - (totalPrice * appliedDiscount / 100)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Total Price: $${discountedPrice}", style = MaterialTheme.typography.titleMedium
        )
        Button(onClick = onConfirmCart) {
            Text("Confirm Cart")
        }
    }
}