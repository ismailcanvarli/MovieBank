//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.model

import com.google.gson.annotations.SerializedName

/**
 * Film verilerini temsil eden model.
 *
 * @property id Filmin ID'si.
 * @property name Filmin adı.
 * @property image Filmin görsel yolu.
 * @property price Filmin fiyatı.
 * @property category Filmin kategorisi.
 * @property rating Filmin kullanıcı oylaması.
 * @property year Filmin yayın yılı.
 * @property director Filmin yönetmeni.
 * @property description Filmin açıklaması.
 */
data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("price") val price: Int,
    @SerializedName("category") val category: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("year") val year: Int,
    @SerializedName("director") val director: String,
    @SerializedName("description") val description: String
)