//Created by canVarli on 1/8/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.room.FavoriteMovieDao
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Favori filmleri yöneten sınıf.
 */
class FavoritesRepository @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
) {
    /**
     * Favori filmleri getirir.
     * @return Favori filmleri içeren akış.
     */
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>> {
        return favoriteMovieDao.getFavoriteMovies()
    }

    /**
     * Bir filmin favori olup olmadığını kontrol eder.
     * @param movieId Kontrol edilecek film ID'si.
     * @return Film favorideyse true, değilse false döner.
     */
    suspend fun isMovieFavorite(movieId: Int): Boolean {
        return favoriteMovieDao.getFavoriteMovieById(movieId) != null
    }

    /**
     * Bir filmi favorilere ekler.
     * @param movie Favorilere eklenecek film.
     */
    suspend fun addFavoriteMovie(movie: FavoriteMovieEntity) {
        favoriteMovieDao.addFavoriteMovie(movie)
    }

    /**
     * Favorilerden bir filmi siler.
     * @param movie Silinecek film.
     */
    suspend fun deleteFavoriteMovie(movie: FavoriteMovieEntity) {
        favoriteMovieDao.deleteFavoriteMovie(movie)
    }
}