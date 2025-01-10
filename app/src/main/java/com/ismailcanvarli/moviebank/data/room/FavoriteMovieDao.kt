//Created by canVarli on 1/8/2025

package com.ismailcanvarli.moviebank.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ismailcanvarli.moviebank.common.Constants
import kotlinx.coroutines.flow.Flow

/**
 * Favori filmlerle ilgili veritabanı işlemlerini yöneten DAO.
 */
@Dao
interface FavoriteMovieDao {

    /**
     * Bir filmi favorilere ekler. Eğer aynı film zaten varsa, eski kayıt üzerine yazılır.
     * @param movie Favorilere eklenecek film.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteMovie(movie: FavoriteMovieEntity)

    /**
     * Tüm favori filmleri getirir.
     * @return Favori filmler listesini içeren Flow.
     */
    @Query("SELECT * FROM ${Constants.MOVIE_FAVORITE_TABLE}")
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>>

    /**
     * Bir filmi favorilerden siler.
     * @param movie Silinecek film.
     */
    @Delete
    suspend fun deleteFavoriteMovie(movie: FavoriteMovieEntity)

    /**
     * Belirtilen ID'ye sahip bir filmi favorilerden siler.
     * @param movieId Silinecek film ID'si.
     */
    @Query("DELETE FROM ${Constants.MOVIE_FAVORITE_TABLE} WHERE movieId = :movieId")
    suspend fun deleteFavoriteMovieById(movieId: Int)

    /**
     * Belirtilen ID'ye sahip bir filmin favori olup olmadığını kontrol eder.
     * @param movieId Kontrol edilecek film ID'si.
     * @return Film favoriyse true, değilse false döner.
     */
    @Query("SELECT EXISTS(SELECT 1 FROM ${Constants.MOVIE_FAVORITE_TABLE} WHERE movieId = :movieId)")
    suspend fun isMovieFavorite(movieId: Int): Boolean

    /**
     * Belirtilen ID'ye sahip favori bir filmi getirir.
     * @param movieId Film ID'si.
     * @return Favori film veya null.
     */
    @Query("SELECT * FROM favorite_movies WHERE movieId = :movieId LIMIT 1")
    suspend fun getFavoriteMovieById(movieId: Int): FavoriteMovieEntity?
}