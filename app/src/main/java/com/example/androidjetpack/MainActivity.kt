package com.example.androidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)

        val programmingAdapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1, "J", "Java")
        val p2 = ProgrammingItem(2, "S", "Scala")
        val p3 = ProgrammingItem(3, "P", "Python")
        val p4 = ProgrammingItem(4, "C", "C++")

        programmingAdapter.submitList(listOf(p1, p2, p3, p4))


        rv.adapter = programmingAdapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        Handler(Looper.getMainLooper()).postDelayed({

            val p5 = ProgrammingItem(5, "R", "Ruby")
            val p6 = ProgrammingItem(6, "D", "Dart")
            val p7 = ProgrammingItem(2, "S", "Scala")
            val p8 = ProgrammingItem(3, "P", "Python")

            programmingAdapter.submitList(listOf(p7, p8, p5, p6))

        }, 2000)
    }
}