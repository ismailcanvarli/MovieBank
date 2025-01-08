package com.ismailcanvarli.moviebank.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ismailcanvarli.moviebank.common.Constants

@Entity(tableName = Constants.MOVIE_FAVORITE_TABLE)
data class FavoriteMovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val movieId: Int,
    val name: String,
    val image: String,
    val price: Int,
    val category: String,
    val rating: Double,
    val year: Int,
    val director: String,
    val description: String
)