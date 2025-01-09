//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.model.CrudResponse
import com.ismailcanvarli.moviebank.data.model.Movie
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Film verilerini yöneten sınıf.
 */
class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {
    /**
     * Tüm filmleri getirir.
     * @return Filmleri içeren akış.
     */
    fun getAllMovies(): Flow<List<Movie>> = flow {
        val response = apiService.getAllMovies()
        emit(response.movies)
    }

    /**
     * Bir filmi sepete ekler.
     * @param movie Sepete eklenecek film.
     * @param orderAmount Sipariş miktarı.
     * @param userName Kullanıcı adı.
     * @return İşlem sonucunu içeren yanıt modeli.
     */
    suspend fun addMovieToCart(
        movie: Movie, orderAmount: Int, userName: String
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

    /**
     * Kullanıcının sepetindeki filmleri getirir.
     * @param userName Kullanıcı adı.
     * @return Sepetteki filmlerin listesi.
     */
    suspend fun getCartMovies(userName: String): List<MovieCart> {
        val response = apiService.getCartMovies(userName)
        return response.movieCart
    }

    /**
     * Sepetten bir filmi siler.
     * @param cartId Silinecek filmin sepet ID'si.
     * @param userName Kullanıcı adı.
     * @return İşlem sonucunu içeren yanıt modeli.
     */
    suspend fun deleteMovieFromCart(cartId: Int, userName: String): CrudResponse {
        return apiService.deleteMovieFromCart(cartId, userName)
    }
}