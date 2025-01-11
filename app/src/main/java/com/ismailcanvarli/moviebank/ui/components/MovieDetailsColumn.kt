//Created by canVarli on 1/11/2025

package com.ismailcanvarli.moviebank.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.data.model.Movie

/**
 * Film detaylarını gösteren sütun bileşeni.
 *
 * @param movie Gösterilecek film bilgisi.
 * @param modifier Bileşenin modifikatörü.
 */
@Composable
fun MovieDetailsColumn(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    val translatedCategory = when (movie.category) {
        "Action" -> stringResource(id = R.string.category_action)
        "Comedy" -> stringResource(id = R.string.category_comedy)
        "Drama" -> stringResource(id = R.string.category_drama)
        "Horror" -> stringResource(id = R.string.category_horror)
        "Science Fiction" -> stringResource(id = R.string.category_scifi)
        "Romance" -> stringResource(id = R.string.category_romance)
        "Thriller" -> stringResource(id = R.string.category_thriller)
        else -> movie.category
    }

    Column(
        modifier = modifier, horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = movie.name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_director),
                contentDescription = stringResource(R.string.director_label),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = movie.director, style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_attach_money),
                contentDescription = stringResource(R.string.movie_price),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${movie.price} $", style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_rating_star),
                contentDescription = stringResource(R.string.rating_label),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${movie.rating}", style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_category),
                contentDescription = stringResource(R.string.category_label),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = translatedCategory, style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}