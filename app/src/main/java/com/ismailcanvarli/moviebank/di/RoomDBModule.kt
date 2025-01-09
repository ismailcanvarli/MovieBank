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

/**
 * Room veritabanı ile ilgili bağımlılıkları sağlayan Hilt modülü.
 */
@Module
@InstallIn(SingletonComponent::class)
class RoomDBModule {

    /**
     * Room veritabanı örneğini oluşturur ve sağlar.
     * @param context Uygulama bağlamı.
     * @return AppDatabase nesnesi.
     */
    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    /**
     * Filmlerle ilgili veritabanı işlemleri için DAO'yu sağlar.
     * @param appDatabase Room veritabanı örneği.
     * @return MovieDao nesnesi.
     */
    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    /**
     * Favorilerle ilgili veritabanı işlemleri için DAO'yu sağlar.
     * @param appDatabase Room veritabanı örneği.
     * @return FavoriteMovieDao nesnesi.
     */
    @Provides
    @Singleton
    fun provideFavoriteMovieDao(appDatabase: AppDatabase): FavoriteMovieDao {
        return appDatabase.favoriteMovieDao()
    }
}