//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.R

/**
 * Kullanıcının sepet ekranını oluşturur.
 * Sepetteki tüm filmleri gösterir, toplam fiyatı hesaplar ve indirim kodu ekler.
 *
 * @param viewModel Sepet verilerini yöneten ViewModel.
 */
@Composable
fun MovieCartScreen(viewModel: MovieCartViewModel) {
    val cartMovies by viewModel.cartMovies.collectAsState()
    val appliedDiscount = remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.fetchCartMovies(Constants.USER_NAME)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        if (cartMovies.isEmpty()) {
            Text(
                text = stringResource(R.string.cart_empty_message),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartMovies) { movie ->
                    MovieCartItem(
                        movie = movie,
                        onIncrement = { viewModel.incrementMovieAmount(movie) },
                        onDecrement = { viewModel.decrementMovieAmount(movie) },
                        onRemove = {
                            viewModel.deleteAllInstancesOfMovie(movie.name, Constants.USER_NAME)
                        }
                    )
                }
            }
            Column {
                DiscountCodeSection { enteredCode ->
                    if (enteredCode == Constants.DISCOUNT_CODE) {
                        appliedDiscount.value = 10
                    } else {
                        appliedDiscount.value = 0
                    }
                }
                TotalPriceSection(
                    cartMovies = cartMovies,
                    appliedDiscount = appliedDiscount.value,
                    onConfirmCart = { /* Sepeti onayla işlemleri */ }
                )
            }
        }
    }
}