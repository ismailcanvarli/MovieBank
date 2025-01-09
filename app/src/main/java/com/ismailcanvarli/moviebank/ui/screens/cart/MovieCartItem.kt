//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.MovieCart

@Composable
fun MovieCartItem(
    movie: MovieCart, onIncrement: () -> Unit, onDecrement: () -> Unit, onRemove: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
            contentDescription = movie.name,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = movie.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Price: ${movie.price}$", style = MaterialTheme.typography.bodySmall)
            Text(text = "Amount: ${movie.orderAmount}", style = MaterialTheme.typography.bodySmall)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Azaltma butonu
            IconButton(
                onClick = onDecrement, enabled = movie.orderAmount > 1
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_decrease),
                    contentDescription = "Decrease order amount"
                )
            }
            Text(
                text = "${movie.orderAmount}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            // Arttırma butonu
            IconButton(onClick = onIncrement) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_increase),
                    contentDescription = "Increase order amount"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            // Silme butonu
            IconButton(onClick = onRemove) {
                Icon(
                    imageVector = Icons.Default.Delete, contentDescription = "Remove all instances"
                )
            }
        }
    }
}