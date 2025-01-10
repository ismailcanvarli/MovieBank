//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.ui.components.MovieCard

/**
 * Tüm filmleri listeleyen ana ekran.
 * Kullanıcı bir filmin detay sayfasına geçiş yapabilir.
 *
 * @param navController Navigasyon işlemlerini yöneten kontrolör.
 * @param viewModel Ana ekranı yöneten ViewModel.
 */
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    val movieList by viewModel.movieList.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val sortOptions = mapOf(
        "NAME_ASC" to stringResource(R.string.sort_name_asc),
        "NAME_DESC" to stringResource(R.string.sort_name_desc),
        "RATING_HIGH" to stringResource(R.string.sort_rating_high),
        "RATING_LOW" to stringResource(R.string.sort_rating_low),
        "PRICE_LOW" to stringResource(R.string.sort_price_low),
        "PRICE_HIGH" to stringResource(R.string.sort_price_high)
    )
    var selectedSortKey by remember { mutableStateOf("NAME_ASC") }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                placeholder = { Text(text = stringResource(R.string.search_placeholder))},
                singleLine = true,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            DropdownMenuWithSelection(options = sortOptions.values.toList(),
                selectedOption = sortOptions[selectedSortKey] ?: "",
                onOptionSelected = { selectedText ->
                    selectedSortKey =
                        sortOptions.entries.firstOrNull { it.value == selectedText }?.key
                            ?: "NAME_ASC"
                    viewModel.updateSortOption(selectedSortKey)
                })
        }

        if (errorMessage != null) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = errorMessage ?: "", style = MaterialTheme.typography.bodyMedium
                )
            }
        } else if (movieList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.movie_not_found),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(movieList) { movie ->
                    MovieCard(movie = movie,
                        onClick = { navController.navigate("movieDetailScreen/${movie.id}") })
                }
            }
        }
    }
}