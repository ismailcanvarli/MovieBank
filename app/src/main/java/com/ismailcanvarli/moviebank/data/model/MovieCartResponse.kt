//Created by canVarli on 1/8/2025

package com.ismailcanvarli.moviebank.data.model

import com.google.gson.annotations.SerializedName

/**
 * Sepetteki filmleri içeren API yanıt modeli.
 *
 * @property movieCart Sepetteki filmler listesini içerir.
 */
data class MovieCartResponse(
    @SerializedName("movie_cart") val movieCart: List<MovieCart>
)