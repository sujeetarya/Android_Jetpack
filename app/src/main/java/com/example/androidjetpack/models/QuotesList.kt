package com.example.androidjetpack.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class QuotesList(
    val count: String,
    val totalCount: Int,
    val page: Int,
    val totalPages: Int,
    val lastItemIndex: Int,
    val results: List<Quote>
)
@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val quotesId:Int,
    val _id: String,
    val author: String,
    val content: String,
//    val tags: Array<String>,
    val authorSlug: String,
    val length: Int,
    val dateAdded: String,
    val dateModified: String,
)
