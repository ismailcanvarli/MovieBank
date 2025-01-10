//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
    userName: String = Constants.USER_NAME
) {
    var orderAmount by remember { mutableIntStateOf(1) }
    val isFavorite by viewModel.isFavorite.collectAsState()

    LaunchedEffect(movie.id) {
        viewModel.checkIfFavorite(movie.id)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
        ) {
            item {
                MovieDetailContent(
                    movie = movie,
                    isFavorite = isFavorite,
                    onToggleFavorite = { favoriteMovie ->
                        viewModel.toggleFavorite(favoriteMovie)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        MovieOrderItem(
            moviePrice = movie.price,
            orderAmount = orderAmount,
            onIncrement = { orderAmount++ },
            onDecrement = { if (orderAmount > 1) orderAmount-- },
            onAddToCart = {
                viewModel.addMovieToCart(movie, userName, orderAmount)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}