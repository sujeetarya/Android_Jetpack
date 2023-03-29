package com.example.androidjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainActivityVM: MainActivityVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val quoteDao = QuoteDatabase.getDatabase(this).getQuoteDao()

        val repository = QuoteRepository(quoteDao)

        mainActivityVM = ViewModelProvider(this, MainActivityVMFactory(repository)).get(MainActivityVM::class.java)

        mainActivityVM.getQuotes().observe(this, {
            binding.quote = it.toString()
        })

        binding.btnInsert.setOnClickListener {
            mainActivityVM.insertQuote(Quote(0, "Just Do It", "Person"))
        }


    }
}