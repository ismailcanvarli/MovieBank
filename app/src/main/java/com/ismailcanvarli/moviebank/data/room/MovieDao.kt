//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToCart(movie: MovieCartEntity)

    @Query("SELECT * FROM movie_cart WHERE userName = :userName")
    suspend fun getCartMovies(userName: String): List<MovieCartEntity>

    @Delete
    suspend fun deleteMovieFromCart(movie: MovieCartEntity)
}