package com.ismailcanvarli.moviebank.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ismailcanvarli.moviebank.common.Constants

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