package com.ismailcanvarli.moviebank.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_cart")
data class MovieCart(
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
