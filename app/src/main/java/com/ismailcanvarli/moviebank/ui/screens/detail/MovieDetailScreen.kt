//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.R

/**
 * Film detaylarını ve kullanıcı etkileşimlerini yöneten ekran.
 * Kullanıcı filme sipariş verebilir veya favorilere ekleyebilir.
 *
 * @param movie Gösterilecek film bilgisi.
 * @param viewModel Detay ekranını yöneten ViewModel.
 * @param navController Navigation kontrolcüsü.
 * @param userName Kullanıcının adı (varsayılan değer Constants.USER_NAME).
 */
@Composable
fun MovieDetailScreen(
    movie: Movie,
    viewModel: MovieDetailViewModel,
    navController: NavController,
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
                .padding(top = 80.dp, bottom = 80.dp)
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(
                    color = Color.Black.copy(alpha = 0.5f)
                )
                .align(Alignment.TopCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = stringResource(R.string.back_button_description),
                        tint = Color.White
                    )
                }

                Text(
                    text = movie.name,
                    style = androidx.compose.material3.MaterialTheme.typography.titleLarge.copy(
                        color = Color.White
                    ),
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
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
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}