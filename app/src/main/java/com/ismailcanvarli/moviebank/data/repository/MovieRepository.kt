//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.remote.ApiService
import com.ismailcanvarli.moviebank.data.room.MovieCartEntity
import com.ismailcanvarli.moviebank.data.room.MovieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService, private val movieDao: MovieDao
) {

    // Tüm filmleri getir (Remote)
    suspend fun getAllMovies(): Flow<List<Movie>> = flow {
        val response = apiService.getAllMovies()
        emit(response.movies)
    }

    // Sepetteki filmleri getir (Local)
    suspend fun getCartMovies(userName: String): Flow<List<MovieCartEntity>> = flow {
        val cartMovies = movieDao.getCartMovies(userName)
        emit(cartMovies)
    }

    // Filme ekleme (Remote ve Local)
    suspend fun addMovieToCart(movieCart: MovieCartEntity) {
        movieDao.addMovieToCart(movieCart)
    }

    // Sepetten film silme (Local)
    suspend fun deleteMovieFromCart(movieCart: MovieCartEntity) {
        movieDao.deleteMovieFromCart(movieCart)
    }
}