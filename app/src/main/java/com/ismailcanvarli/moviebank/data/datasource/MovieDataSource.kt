//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.datasource

import com.ismailcanvarli.moviebank.data.entity.Movie
import com.ismailcanvarli.moviebank.retrofit.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSource(var movieDao: MovieDao) {
    suspend fun getAllMovies(): List<Movie> = withContext(Dispatchers.IO) {
        val response = movieDao.getAllMovies()
        return@withContext response.movies ?: emptyList()
    }
}