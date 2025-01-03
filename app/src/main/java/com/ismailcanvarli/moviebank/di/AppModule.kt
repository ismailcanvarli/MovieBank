package com.ismailcanvarli.moviebank.di

import com.ismailcanvarli.moviebank.data.datasource.MovieDataSource
import com.ismailcanvarli.moviebank.data.repository.MovieRepository
import com.ismailcanvarli.moviebank.retrofit.ApiUtils
import com.ismailcanvarli.moviebank.retrofit.MovieDao
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
    fun provideMovieRepository(movieDataSource: MovieDataSource): MovieRepository {
        return MovieRepository(movieDataSource)
    }

    @Provides
    @Singleton
    fun provideMovieDataSource(movieDao: MovieDao): MovieDataSource {
        return MovieDataSource(movieDao)
    }

    @Provides
    @Singleton
    fun provideMovieDao(): MovieDao {
        return ApiUtils.getMovieDao()
    }
}