//Created by canVarli on 1/3/2025

package com.ismailcanvarli.moviebank.retrofit

class ApiUtils {
    companion object {
        const val BASE_URL = "http://kasimadalan.pe.hu/"
        const val IMAGE_PATH = "movies/images/"

        fun getMovieDao(): MovieDao {
            return RetrofitClient.getRetrofitClient(BASE_URL).create(MovieDao::class.java)
        }

        fun getImageUrl(imageName: String?): String {
            if (imageName.isNullOrBlank()) {
                throw IllegalArgumentException("Image name cannot be null or empty")
            }
            return "$BASE_URL$IMAGE_PATH$imageName"
        }
    }
}