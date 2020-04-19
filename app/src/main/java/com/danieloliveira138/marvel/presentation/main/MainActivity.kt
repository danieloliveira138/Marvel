package com.danieloliveira138.marvel.presentation.main

import android.os.Bundle
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.presentation.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initData()
    }

    private fun initData() {
        viewModel.fetchData()
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
    }
}
