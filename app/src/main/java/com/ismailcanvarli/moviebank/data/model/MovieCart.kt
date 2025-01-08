package com.ismailcanvarli.moviebank.data.model

import com.google.gson.annotations.SerializedName

data class MovieCart(
    @SerializedName("cart_id") val cartId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("price") val price: Int,
    @SerializedName("category") val category: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("year") val year: Int,
    @SerializedName("director") val director: String,
    @SerializedName("description") val description: String,
    @SerializedName("order_amount") val orderAmount: Int,
    @SerializedName("user_name") val userName: String
)