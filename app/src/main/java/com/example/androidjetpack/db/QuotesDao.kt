package com.example.androidjetpack.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidjetpack.models.Quote

@Dao
interface QuotesDao {
    @Query("SELECT * FROM quotes")
    suspend fun getQuotes(): List<Quote>

    @Insert
    suspend fun insertQuotes(quotesList: List<Quote>)
}