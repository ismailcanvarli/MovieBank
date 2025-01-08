//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.di

import android.content.Context
import androidx.room.Room
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.room.AppDatabase
import com.ismailcanvarli.moviebank.data.room.FavoriteMovieDao
import com.ismailcanvarli.moviebank.data.room.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDBModule {

    // Room DB
    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    // Filmler için Dao
    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    // Favoriler için Dao
    @Provides
    @Singleton
    fun provideFavoriteMovieDao(appDatabase: AppDatabase): FavoriteMovieDao {
        return appDatabase.favoriteMovieDao()
    }
}