//Created by canVarli on 1/10/2025

package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity

/**
 * Film detaylarını gösteren bileşen.
 *
 * @param movie Gösterilecek film bilgisi.
 * @param isFavorite Film favorilere ekli mi?
 * @param onToggleFavorite Favori durumunu değiştiren fonksiyon.
 * @param modifier Bileşenin modifikatörü.
 *
 */
@Composable
fun MovieDetailContent(
    movie: Movie,
    isFavorite: Boolean,
    onToggleFavorite: (FavoriteMovieEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(8.dp)) {
        Box {
            AsyncImage(
                model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                contentDescription = movie.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
            )

            AddToFavoriteButton(
                isFavorite = isFavorite, onToggleFavorite = {
                    onToggleFavorite(
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
                }, modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = movie.name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.category_label, movie.category),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.rating_label, movie.rating),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.year_label, movie.year),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.director_label, movie.director),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = movie.description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
    }
}