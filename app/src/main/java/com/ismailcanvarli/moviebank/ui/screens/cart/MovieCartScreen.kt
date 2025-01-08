//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.common.Constants

@Composable
fun MovieCartScreen(viewModel: MovieCartViewModel) {
    val cartMovies by viewModel.cartMovies.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCartMovies(Constants.USER_NAME)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (cartMovies.isEmpty()) {
            // Sepet boş ise bu mesaj gösterilecek
            Text(
                text = "Your cart is empty.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        } else {
            // Sepetteki filmleri listeleme
            LazyColumn(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartMovies) { movie ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Film Görseli
                        AsyncImage(
                            model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                            contentDescription = movie.name,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        // Film Bilgileri
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = movie.name, style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Price: ${movie.price}$",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        // Silme Butonu
                        Button(onClick = {
                            viewModel.deleteMovieFromCart(
                                movie.cartId, Constants.USER_NAME
                            )
                        }) {
                            Text("Remove")
                        }
                    }
                }
            }
        }
    }
}