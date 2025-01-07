//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.remote

import com.ismailcanvarli.moviebank.data.entity.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteMovieDataSource(var remoteMovieApi: RemoteMovieApi) {
    suspend fun getAllMovies(): List<Movie> = withContext(Dispatchers.IO) {
        val response = remoteMovieApi.getAllMovies()
        return@withContext response.movies
    }
}