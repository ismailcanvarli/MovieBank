//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.remote

import com.ismailcanvarli.moviebank.data.model.CrudResponse
import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.model.MovieResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("movies/getAllMovies.php")
    suspend fun getAllMovies(): MovieResponse

    @POST("movies/insertMovie.php")
    @FormUrlEncoded
    suspend fun addMovieToCart(
        @Field("name") name: String,
        @Field("image") image: String,
        @Field("price") price: Int,
        @Field("category") category: String,
        @Field("rating") rating: Double,
        @Field("year") year: Int,
        @Field("director") director: String,
        @Field("description") description: String,
        @Field("orderAmount") orderAmount: Int,
        @Field("userName") userName: String
    ): CrudResponse

    @POST("movies/getMovieCart.php")
    @FormUrlEncoded
    suspend fun getCartMovies(@Field("userName") userName: String): List<MovieCart>

    @POST("movies/deleteMovie.php")
    @FormUrlEncoded
    suspend fun deleteMovieFromCart(
        @Field("cartId") cartId: Int, @Field("userName") userName: String
    ): CrudResponse
}