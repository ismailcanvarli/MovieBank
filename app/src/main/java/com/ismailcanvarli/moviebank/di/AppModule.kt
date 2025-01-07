package com.ismailcanvarli.moviebank.di

import com.ismailcanvarli.moviebank.data.remote.RemoteMovieDataSource
import com.ismailcanvarli.moviebank.data.repository.RemoteMovieRepository
import com.ismailcanvarli.moviebank.retrofit.ApiUtils
import com.ismailcanvarli.moviebank.data.remote.RemoteMovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMovieRepository(remoteMovieDataSource: RemoteMovieDataSource): RemoteMovieRepository {
        return RemoteMovieRepository(remoteMovieDataSource)
    }

    @Provides
    @Singleton
    fun provideMovieDataSource(remoteMovieApi: RemoteMovieApi): RemoteMovieDataSource {
        return RemoteMovieDataSource(remoteMovieApi)
    }

    @Provides
    @Singleton
    fun provideMovieDao(): RemoteMovieApi {
        return ApiUtils.getMovieDao()
    }
}