//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.data.entity.Movie
import com.ismailcanvarli.moviebank.retrofit.ApiUtils

@Composable
fun MovieRow(movie: Movie, onMovieClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onMovieClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ApiUtils.getImageUrl(movie.image),
            contentDescription = movie.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = movie.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Year: ${movie.year}", style = MaterialTheme.typography.bodySmall)
        }
    }
}