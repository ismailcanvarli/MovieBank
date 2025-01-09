package com.ismailcanvarli.moviebank.common

/**
 * Uygulama genelinde kullanılan sabit değerler.
 */
object Constants {
    const val BASE_URL = "http://kasimadalan.pe.hu/" // API'nin temel URL'si
    const val DATABASE_NAME = "movie_db" // Veritabanı adı
    const val MOVIE_FAVORITE_TABLE = "favorite_movies" // Favori filmler tablosu
    const val MOVIE_CART_TABLE = "movie_cart" // Film sepeti tablosu
    const val IMAGE_PATH = "movies/images/" // Resimlerin bulunduğu dizin
    const val USER_NAME = "ismailcanvarli" // Varsayılan kullanıcı adı
    val DISCOUNT_CODES = mapOf(
        "DISCOUNT10" to 10, // %10 indirim
        "WELCOME20" to 20  // %20 indirim
    )
}