package com.ismailcanvarli.moviebank.di

import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Ağ (network) ile ilgili bağımlılıkları sağlayan Hilt modülü.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
     * Retrofit nesnesini oluşturur ve sağlar.
     * @return Retrofit yapılandırması.
     */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * ApiService nesnesini oluşturur ve sağlar.
     * @param retrofit Retrofit nesnesi.
     * @return ApiService arayüzü.
     */
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}