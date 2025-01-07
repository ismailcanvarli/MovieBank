//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.data.entity.Movie

@Composable
fun MovieDetailScreen(movie: Movie?) {
    movie?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "http://kasimadalan.pe.hu/movies/images/${movie.image}",
                contentDescription = movie.name,
                modifier = Modifier.size(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = movie.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Director: ${movie.director}")
            Text(text = "Year: ${movie.year}")
            Text(text = "Rating: ${movie.rating}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.description)
        }
    } ?: Text(text = "Movie not found!", modifier = Modifier.padding(16.dp))
}
