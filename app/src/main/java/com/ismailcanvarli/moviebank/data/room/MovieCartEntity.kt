package com.ismailcanvarli.moviebank.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ismailcanvarli.moviebank.common.Constants

/**
 * Film sepetini temsil eden Room veritabanı varlığı.
 *
 * @property cartId Otomatik oluşturulan birincil anahtar.
 * @property name Filmin adı.
 * @property image Filmin görsel yolu.
 * @property price Filmin fiyatı.
 * @property category Filmin kategorisi.
 * @property rating Filmin kullanıcı puanı.
 * @property year Filmin yayın yılı.
 * @property director Filmin yönetmeni.
 * @property description Filmin açıklaması.
 * @property orderAmount Sipariş edilen miktar.
 * @property userName Kullanıcı adı.
 */
@Entity(tableName = Constants.MOVIE_CART_TABLE)
data class MovieCartEntity(
    @PrimaryKey(autoGenerate = true) val cartId: Int = 0,
    val name: String,
    val image: String,
    val price: Int,
    val category: String,
    val rating: Double,
    val year: Int,
    val director: String,
    val description: String,
    val orderAmount: Int,
    val userName: String
)