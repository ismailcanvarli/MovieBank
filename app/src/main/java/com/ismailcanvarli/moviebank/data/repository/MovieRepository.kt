//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.model.CrudResponse
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {

    // Tüm filmleri getir (Remote)
    fun getAllMovies(): Flow<List<Movie>> = flow {
        val response = apiService.getAllMovies()
        emit(response.movies)
    }

    // Sepete film ekleme
    suspend fun addMovieToCart(
        movie: Movie,
        orderAmount: Int,
        userName: String
    ): CrudResponse {
        return apiService.addMovieToCart(
            name = movie.name,
            image = movie.image,
            price = movie.price,
            category = movie.category,
            rating = movie.rating,
            year = movie.year,
            director = movie.director,
            description = movie.description,
            orderAmount = orderAmount,
            userName = userName
        )
    }

    // Sepeti getir
    suspend fun getCartMovies(userName: String): List<MovieCart> {
        val response = apiService.getCartMovies(userName)
        return response.movieCart
    }

    // Sepetten film silme
    suspend fun deleteMovieFromCart(cartId: Int, userName: String): CrudResponse {
        return apiService.deleteMovieFromCart(cartId, userName)
    }
}