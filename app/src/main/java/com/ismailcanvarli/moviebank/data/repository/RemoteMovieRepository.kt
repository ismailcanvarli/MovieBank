//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.entity.Movie
import com.ismailcanvarli.moviebank.data.remote.RemoteMovieDataSource

class RemoteMovieRepository(var remoteMovieDataSource: RemoteMovieDataSource) {
    suspend fun getAllMovies(): List<Movie> = remoteMovieDataSource.getAllMovies()
}