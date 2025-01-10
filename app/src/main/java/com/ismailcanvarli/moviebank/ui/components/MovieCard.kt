//Created by canVarli on 1/10/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie

/**
 * Film kartı bileşeni.
 * Film bilgilerini ve isteğe bağlı bir işlem düğmesini içerir.
 *
 * @param movie Gösterilecek film bilgisi (Movie veya FavoriteMovieEntity türünde).
 * @param onClick Kart tıklama işlemini tetikleyen callback (isteğe bağlı).
 */
@Composable
fun MovieCard(movie: Movie, onClick: () -> Unit, actionButton: @Composable (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                contentDescription = movie.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = stringResource(R.string.movie_title, movie.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(R.string.movie_director, movie.director),
                    style = MaterialTheme.typography.bodySmall
                )
                actionButton?.let { it() } // Action Button'u çağırma
            }
        }
    }
}