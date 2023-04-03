package com.example.androidjetpack.models

data class QuotesList(
    val count: String,
    val totalCount: Int,
    val page: Int,
    val totalPages: Int,
    val lastItemIndex: Int,
    val results: Array<Quote>
)

data class Quote(
    val _id: String,
    val author: String,
    val content: String,
    val tags: Array<String>,
    val authorSlug: String,
    val length: Int,
    val dateAdded: String,
    val dateModified: String,
)
