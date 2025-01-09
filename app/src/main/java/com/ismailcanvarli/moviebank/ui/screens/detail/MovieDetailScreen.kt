//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import com.ismailcanvarli.moviebank.ui.components.AddToCartButton
import com.ismailcanvarli.moviebank.ui.components.FavoriteToggleButton
import com.ismailcanvarli.moviebank.ui.components.MovieDetailCard

@Composable
fun MovieDetailScreen(
    movie: Movie,
    viewModel: MovieDetailViewModel,
    userName: String = Constants.USER_NAME,
) {
    val isFavorite by viewModel.isFavorite.collectAsState()
    var orderAmount by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = movie.id) {
        viewModel.checkIfFavorite(movie.id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MovieDetailCard(movie)
        Spacer(modifier = Modifier.height(12.dp))
        MovieOrderControls(orderAmount, { if (orderAmount > 0) orderAmount-- }, { orderAmount++ })
        Spacer(modifier = Modifier.height(16.dp))
        AddToCartButton(orderAmount) {
            if (orderAmount > 0) {
                viewModel.addMovieToCart(
                    movie = movie, userName = userName, orderAmount = orderAmount
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        FavoriteToggleButton(isFavorite) {
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
        }
    }
}