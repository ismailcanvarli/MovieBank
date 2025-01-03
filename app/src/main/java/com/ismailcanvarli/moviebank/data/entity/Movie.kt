//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.data.entity

data class Movie(
    val id: Int,
    val name: String,
    val image: String,
    val price: Int,
    val category: String,
    val rating: Double,
    val year: Int,
    val director: String,
    val description: String
)