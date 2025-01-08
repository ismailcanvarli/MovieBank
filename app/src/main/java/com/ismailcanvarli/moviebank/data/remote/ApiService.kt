//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.remote

import com.ismailcanvarli.moviebank.data.model.MovieCart
import com.ismailcanvarli.moviebank.data.model.MovieResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movies/getAllMovies.php")
    suspend fun getAllMovies(): Response<MovieResponse>

    @GET("movies/images/{image}")
    suspend fun getMovieImage(@Path("image") imageName: String): Response<ResponseBody>

    @GET("movies/getMovieCart.php")
    suspend fun getMovieCart(@Query("userName") userName: String): Response<List<MovieCart>>

    @POST("movies/insertMovie.php")
    suspend fun insertMovieToCart(@Body movieCart: MovieCart): Response<ResponseBody>

    @POST("movies/deleteMovie.php")
    suspend fun deleteMovieFromCart(@Query("cartId") cartId: Int, @Query("userName") userName: String): Response<ResponseBody>
}
