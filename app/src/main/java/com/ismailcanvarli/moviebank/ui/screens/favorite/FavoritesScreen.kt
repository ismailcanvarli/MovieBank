//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.screens.favorite


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel
) {
    val favoriteMovies by viewModel.favoriteMovies.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteMovies) { favoriteMovie ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = favoriteMovie.name)
                    Text(text = "Director: ${favoriteMovie.director}")
                    Text(text = "Year: ${favoriteMovie.year}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { viewModel.removeFavorite(favoriteMovie) }) {
                        Text("Remove from Favorites")
                    }
                }
            }
        }
    }
}