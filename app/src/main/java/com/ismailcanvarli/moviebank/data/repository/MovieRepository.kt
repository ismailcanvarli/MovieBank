//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.repository

import androidx.lifecycle.LiveData
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.remote.ApiService
import com.ismailcanvarli.moviebank.data.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.logging.Logger
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService, private val movieDao: MovieDao
) {
    private val logger = Logger.getLogger(MovieRepository::class.java.name)


    fun getFavoriteMovies(): LiveData<List<Movie>> = movieDao.getFavoriteMovies()

    suspend fun addFavorite(movie: Movie) {
        withContext(Dispatchers.IO) {
            movieDao.insertMovie(movie)
        }
    }

    suspend fun removeFavorite(movie: Movie) {
        withContext(Dispatchers.IO) {
            movieDao.deleteMovie(movie)
        }
    }
}