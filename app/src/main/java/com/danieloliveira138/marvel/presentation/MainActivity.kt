package com.danieloliveira138.marvel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danieloliveira138.marvel.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
    }
}
