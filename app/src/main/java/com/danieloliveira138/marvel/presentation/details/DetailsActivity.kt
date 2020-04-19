package com.danieloliveira138.marvel.presentation.details

import android.os.Bundle
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.presentation.BaseActivity

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setContentView(R.layout.activity_details)
    }
}
