//Created by canVarli on 1/8/2025

package com.ismailcanvarli.moviebank.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ismailcanvarli.moviebank.common.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteMovie(movie: FavoriteMovieEntity)

    @Query("SELECT * FROM ${Constants.MOVIE_FAVORITE_TABLE}")
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>>

    @Delete
    suspend fun deleteFavoriteMovie(movie: FavoriteMovieEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM ${Constants.MOVIE_FAVORITE_TABLE} WHERE movieId = :movieId)")
    suspend fun isMovieFavorite(movieId: Int): Boolean
}
