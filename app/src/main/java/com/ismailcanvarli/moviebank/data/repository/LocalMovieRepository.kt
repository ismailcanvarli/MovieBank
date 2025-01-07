//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.local.FavoriteMovieEntity
import com.ismailcanvarli.moviebank.data.local.MovieDao
import javax.inject.Inject

class LocalMovieRepository @Inject constructor(private val movieDao: MovieDao) {
    suspend fun getAllFavorites(): List<FavoriteMovieEntity> {
        return movieDao.getAllFavorites()
    }

    suspend fun addFavorite(movie: FavoriteMovieEntity) {
        movieDao.insertFavorite(movie)
    }

    suspend fun deleteFavorite(movie: FavoriteMovieEntity) {
        movieDao.deleteFavorite(movie)
    }
}