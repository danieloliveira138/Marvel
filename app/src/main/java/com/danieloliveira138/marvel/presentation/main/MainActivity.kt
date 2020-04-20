package com.danieloliveira138.marvel.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.model.Result
import com.danieloliveira138.marvel.presentation.BaseActivity
import com.danieloliveira138.marvel.presentation.main.heroslist.HeroesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter by inject<HeroesAdapter> { parametersOf(::listener) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initData()
    }

    private fun initData() {
        with(viewModel) {
            heroes.observe(this@MainActivity, Observer(::feedList))
            fetchData()
        }
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        heroesList.adapter = adapter
    }

    private fun feedList(heros: List<Result>) {
        adapter.heroes = heros.toMutableList()
    }

    private fun listener(id: Int) {

    }
}
