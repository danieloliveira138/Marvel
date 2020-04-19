package com.danieloliveira138.marvel.presentation.main

import android.os.Bundle
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.presentation.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
    }
}
