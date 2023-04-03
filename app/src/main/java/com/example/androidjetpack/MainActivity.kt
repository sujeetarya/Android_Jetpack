package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.api.QuotesApi
import com.example.androidjetpack.api.RetrofitHelper
import com.example.androidjetpack.repository.QuoteRepository
import com.example.androidjetpack.view_models.MainVMFactory
import com.example.androidjetpack.view_models.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = RetrofitHelper.getInstance(this).create(QuotesApi::class.java)
        val quoteRepository = QuoteRepository(quotesApi)

        mainViewModel = ViewModelProvider(this, MainVMFactory(quoteRepository)).get(MainViewModel::class.java)

        mainViewModel.quote.observe(this, Observer {
            Log.d("API DATA", it.toString())
        })

    }
}