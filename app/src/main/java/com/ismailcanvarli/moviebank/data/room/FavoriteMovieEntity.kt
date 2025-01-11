package com.ismailcanvarli.moviebank.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.model.Movie

/**
 * Favori filmleri temsil eden Room veritabanı varlığı.
 *
 * @property id Otomatik oluşturulan birincil anahtar.
 * @property movieId Filmin benzersiz ID'si.
 * @property name Filmin adı.
 * @property image Filmin görsel yolu.
 * @property price Filmin fiyatı.
 * @property category Filmin kategorisi.
 * @property rating Filmin kullanıcı puanı.
 * @property year Filmin yayın yılı.
 * @property director Filmin yönetmeni.
 * @property description Filmin açıklaması.
 */
@Entity(tableName = Constants.MOVIE_FAVORITE_TABLE)
data class FavoriteMovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val movieId: Int,
    val name: String,
    val image: String,
    val price: Int,
    val category: String,
    val rating: Double,
    val year: Int,
    val director: String,
    val description: String
)

/**
 * Favori filmleri genel bir Movie nesnesine dönüştürür.
 */
fun FavoriteMovieEntity.toMovie(): Movie {
    return Movie(
        id = movieId,
        name = name,
        image = image,
        price = price,
        category = category,
        rating = rating,
        year = year,
        director = director,
        description = description
    )
}