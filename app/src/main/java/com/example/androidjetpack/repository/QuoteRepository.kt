package com.example.androidjetpack.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidjetpack.api.QuotesApi
import com.example.androidjetpack.models.QuotesList

class QuoteRepository(val quotesApi: QuotesApi) {

    private val quotesLiveData = MutableLiveData<QuotesList>()
    val quotes: LiveData<QuotesList>
        get() = quotesLiveData


    suspend fun getQuotes(page: Int) {
        val result = quotesApi.getQuotes(page)
        if (result?.body() != null) {
            quotesLiveData.postValue(result.body())
        }
    }

}