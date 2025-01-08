//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieCartEntity::class, FavoriteMovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun favoriteMovieDao(): FavoriteMovieDao
}