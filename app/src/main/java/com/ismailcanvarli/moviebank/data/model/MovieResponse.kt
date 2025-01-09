//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.model

/**
 * Tüm filmleri içeren API yanıt modeli.
 *
 * @property movies Filmler listesini içerir.
 */
data class MovieResponse(
    val movies: List<Movie>
)