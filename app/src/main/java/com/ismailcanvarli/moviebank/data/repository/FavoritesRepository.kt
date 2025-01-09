//Created by canVarli on 1/8/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.room.FavoriteMovieDao
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepository @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
) {
    // Favori filmleri getir
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>> {
        return favoriteMovieDao.getFavoriteMovies()
    }

    // Favori film kontrolü
    suspend fun isMovieFavorite(movieId: Int): Boolean {
        return favoriteMovieDao.isMovieFavorite(movieId)
    }

    // Favori filme ekleme
    suspend fun addFavoriteMovie(movie: FavoriteMovieEntity) {
        favoriteMovieDao.addFavoriteMovie(movie)
    }

    // Favori film silme
    suspend fun deleteFavoriteMovie(movie: FavoriteMovieEntity) {
        favoriteMovieDao.deleteFavoriteMovie(movie)
    }
}