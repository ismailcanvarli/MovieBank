package com.ismailcanvarli.moviebank.data.model

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

fun MovieCart.toMovie(): Movie {
    return Movie(
        id = this.cartId, // Sepetteki id, veritabanı id'sine eşdeğer olmayabilir
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