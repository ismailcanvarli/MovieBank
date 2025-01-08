//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ismailcanvarli.moviebank.data.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    fun getFavoriteMovies(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}