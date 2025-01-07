//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.remote

import retrofit2.http.GET

interface RemoteMovieApi {
    @GET("movies/getAllMovies.php")
    suspend fun getAllMovies(): RemoteMovieResponse
}