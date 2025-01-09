package com.ismailcanvarli.moviebank.data.model

/**
 * Sepetteki filmleri temsil eden model.
 *
 * @property cartId Sepet öğesinin ID'si.
 * @property name Filmin adı.
 * @property image Filmin görsel yolu.
 * @property price Filmin fiyatı.
 * @property category Filmin kategorisi.
 * @property rating Filmin kullanıcı oylaması.
 * @property year Filmin yayın yılı.
 * @property director Filmin yönetmeni.
 * @property description Filmin açıklaması.
 * @property orderAmount Sipariş edilen miktar.
 * @property userName Kullanıcı adı.
 */
data class MovieCart(
    val cartId: Int,
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

/**
 * Sepetteki bir filmi genel bir Movie nesnesine dönüştürür.
 */
fun MovieCart.toMovie(): Movie {
    return Movie(
        id = this.cartId,
        name = this.name,
        image = this.image,
        price = this.price,
        category = this.category,
        rating = this.rating,
        year = this.year,
        director = this.director,
        description = this.description
    )
}