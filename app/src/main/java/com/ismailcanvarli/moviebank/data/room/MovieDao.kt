package com.ismailcanvarli.moviebank.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Film sepetiyle ilgili veritabanı işlemlerini yöneten DAO.
 */
@Dao
interface MovieDao {

    /**
     * Bir filmi sepete ekler. Eğer aynı film zaten varsa, eski kayıt üzerine yazılır.
     * @param movie Sepete eklenecek film.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToCart(movie: MovieCartEntity)

    /**
     * Belirtilen kullanıcıya ait sepet filmlerini getirir.
     * @param userName Kullanıcı adı.
     * @return Kullanıcının sepetindeki filmler.
     */
    @Query("SELECT * FROM movie_cart WHERE userName = :userName")
    suspend fun getCartMovies(userName: String): List<MovieCartEntity>

    /**
     * Bir filmi sepetten siler.
     * @param movie Silinecek film.
     */
    @Delete
    suspend fun deleteMovieFromCart(movie: MovieCartEntity)
}