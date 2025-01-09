//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.remote

import com.ismailcanvarli.moviebank.data.model.CrudResponse
import com.ismailcanvarli.moviebank.data.model.MovieCartResponse
import com.ismailcanvarli.moviebank.data.model.MovieResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * API çağrılarını gerçekleştiren arayüz.
 */
interface ApiService {

    /**
     * Tüm filmleri getirir.
     * @return Filmler listesini içeren yanıt modeli.
     */
    @GET("movies/getAllMovies.php")
    suspend fun getAllMovies(): MovieResponse

    /**
     * Sepete bir film ekler.
     * @param name Filmin adı.
     * @param image Filmin görsel yolu.
     * @param price Filmin fiyatı.
     * @param category Filmin kategorisi.
     * @param rating Filmin kullanıcı puanı.
     * @param year Filmin yayın yılı.
     * @param director Filmin yönetmeni.
     * @param description Filmin açıklaması.
     * @param orderAmount Sipariş edilen miktar.
     * @param userName Kullanıcı adı.
     * @return İşlem sonucunu içeren yanıt modeli.
     */
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

    /**
     * Sepetteki filmleri getirir.
     * @param userName Kullanıcı adı.
     * @return Sepetteki filmleri içeren yanıt modeli.
     */
    @POST("movies/getMovieCart.php")
    @FormUrlEncoded
    suspend fun getCartMovies(@Field("userName") userName: String): MovieCartResponse

    /**
     * Sepetten bir filmi siler.
     * @param cartId Silinecek filmin sepet ID'si.
     * @param userName Kullanıcı adı.
     * @return İşlem sonucunu içeren yanıt modeli.
     */
    @POST("movies/deleteMovie.php")
    @FormUrlEncoded
    suspend fun deleteMovieFromCart(
        @Field("cartId") cartId: Int, @Field("userName") userName: String
    ): CrudResponse
}