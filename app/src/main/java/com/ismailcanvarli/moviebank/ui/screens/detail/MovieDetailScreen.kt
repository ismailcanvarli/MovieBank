//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity

@Composable
fun MovieDetailScreen(
    movie: Movie,
    viewModel: MovieDetailViewModel,
    userName: String = Constants.USER_NAME,
) {
    val isFavorite by viewModel.isFavorite.collectAsState()
    val addToCartMessage by viewModel.addToCartMessage.collectAsState()

    LaunchedEffect(key1 = movie.id) {
        viewModel.checkIfFavorite(movie.id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
            contentDescription = movie.name,
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = movie.name, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Director: ${movie.director}")
        Text(text = "Year: ${movie.year}")
        Text(text = "Rating: ${movie.rating}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = movie.description)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Favorilere ekleme/çıkarma butonu
            Button(
                onClick = {
                    viewModel.toggleFavorite(
                        FavoriteMovieEntity(
                            movieId = movie.id,
                            name = movie.name,
                            image = movie.image,
                            price = movie.price,
                            category = movie.category,
                            rating = movie.rating,
                            year = movie.year,
                            director = movie.director,
                            description = movie.description
                        )
                    )
                }, modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(if (isFavorite) "Remove from Favorites" else "Add to Favorites")
            }

            // Sepete ekleme butonu
            Button(
                onClick = {
                    viewModel.addMovieToCart(
                        movie = movie, userName = userName, orderAmount = 1
                    )
                }, modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text("Add to Cart")
            }
        }

        // Sepete ekleme yanıtı
        addToCartMessage?.let { message ->
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
            LaunchedEffect(key1 = message) {
                viewModel.clearAddToCartMessage()
            }
        }
    }
}