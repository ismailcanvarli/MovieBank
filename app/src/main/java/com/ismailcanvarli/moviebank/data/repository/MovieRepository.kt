//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.repository

import com.ismailcanvarli.moviebank.data.datasource.MovieDataSource
import com.ismailcanvarli.moviebank.data.entity.Movie

class MovieRepository(var movieDataSource: MovieDataSource) {

    suspend fun getAllMovies(): List<Movie> = movieDataSource.getAllMovies()
}