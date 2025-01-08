//Created by canVarli on 1/8/2025

package com.ismailcanvarli.moviebank.data.model

import com.google.gson.annotations.SerializedName

data class MovieCartResponse(
    @SerializedName("movie_cart") val movieCart: List<MovieCart>
)