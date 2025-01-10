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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity

/**
 * Film detaylarını ve kullanıcı etkileşimlerini yöneten ekran.
 * Kullanıcı filme sipariş verebilir veya favorilere ekleyebilir.
 *
 * @param movie Gösterilecek film bilgisi.
 * @param viewModel Detay ekranını yöneten ViewModel.
 * @param userName Kullanıcının adı (varsayılan değer Constants.USER_NAME).
 */
@Composable
fun MovieDetailScreen(
    movie: Movie,
    viewModel: MovieDetailViewModel,
    userName: String = Constants.USER_NAME,
) {
    var orderAmount by remember { mutableIntStateOf(1) }
    val isFavorite by viewModel.isFavorite.collectAsState()

    LaunchedEffect(movie.id) {
        viewModel.checkIfFavorite(movie.id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = movie.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = stringResource(R.string.movie_director, movie.director),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(R.string.movie_year, movie.year),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            AddToFavoriteButton(isFavorite = isFavorite, onToggleFavorite = {
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
            })
        }

        Spacer(modifier = Modifier.height(16.dp))

        MovieOrderItem(movieName = movie.name,
            movieImage = "",
            orderAmount = orderAmount,
            onIncrement = { orderAmount++ },
            onDecrement = { if (orderAmount > 1) orderAmount-- },
            onAddToCart = {
                if (orderAmount > 0) {
                    viewModel.addMovieToCart(
                        movie = movie, userName = userName, orderAmount = orderAmount
                    )
                }
            })
    }
}