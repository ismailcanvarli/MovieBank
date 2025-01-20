package com.ismailcanvarli.moviebank.ui.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import com.ismailcanvarli.moviebank.ui.components.AddToFavoriteButton
import com.ismailcanvarli.moviebank.ui.components.MovieDetailsColumn
import androidx.compose.runtime.*

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
    var showImageDialog by remember { mutableStateOf(false) }

    Column {
        Box {
            AsyncImage(model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                contentDescription = movie.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clickable { showImageDialog = true })

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

        MovieDetailsColumn(
            movie = movie, modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = movie.description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
    }

    if (showImageDialog) {
        Dialog(onDismissRequest = { showImageDialog = false }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AsyncImage(
                    model = "${Constants.BASE_URL}${Constants.IMAGE_PATH}${movie.image}",
                    contentDescription = movie.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { showImageDialog = false }
                )
            }
        }
    }
}