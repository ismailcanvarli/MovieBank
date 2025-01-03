//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.retrofit

import com.ismailcanvarli.moviebank.data.entity.MovieResponse
import retrofit2.http.GET

interface MovieDao {
    @GET("movies/getAllMovies.php")
    suspend fun getAllMovies(): MovieResponse
}