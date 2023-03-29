package com.example.androidjetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityVM(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun insertQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(quote)
        }
    }

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuotes()
    }
}