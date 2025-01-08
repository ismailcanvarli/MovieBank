//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.di

import android.content.Context
import androidx.room.Room
import com.ismailcanvarli.moviebank.common.Constants
import com.ismailcanvarli.moviebank.data.room.MovieDB
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

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): MovieDB {
        return Room.databaseBuilder(
            context,
            MovieDB::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieDB: MovieDB): MovieDao {
        return movieDB.movieDao()
    }
}