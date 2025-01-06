//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.retrofit

class ApiUtils {
    companion object {
        const val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getMovieDao(): MovieDao {
            return RetrofitClient.getRetrofitClient(BASE_URL).create(MovieDao::class.java)
        }
    }
}