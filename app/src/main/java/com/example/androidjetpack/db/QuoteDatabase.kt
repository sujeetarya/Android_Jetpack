package com.example.androidjetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidjetpack.models.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quotesDao(): QuotesDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null
        fun getDatabase(context: Context): QuoteDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context, QuoteDatabase::class.java, "quotesDB").build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

}