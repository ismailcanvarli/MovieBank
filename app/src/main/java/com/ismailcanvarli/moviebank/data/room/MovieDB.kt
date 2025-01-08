//Created by canVarli on 1/7/2025

package com.ismailcanvarli.moviebank.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ismailcanvarli.moviebank.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}