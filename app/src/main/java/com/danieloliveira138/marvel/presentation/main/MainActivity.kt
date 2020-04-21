package com.danieloliveira138.marvel.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.components.OnScrollListenerDelegate
import com.danieloliveira138.marvel.model.Result
import com.danieloliveira138.marvel.presentation.BaseActivity
import com.danieloliveira138.marvel.presentation.main.heroslist.HeroesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import timber.log.Timber

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter by inject<HeroesAdapter> { parametersOf(::listener) }
    private val onScrollListenerDelegate: OnScrollListenerDelegate by lazy { OnScrollListenerDelegate(::onScrollDown) }

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
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        heroesList.adapter = adapter
        heroesList.addOnScrollListener(onScrollListenerDelegate)
    }

    private fun onScrollDown() {
        viewModel.fetchData(adapter.heroes.size)
    }

    private fun feedList(heroes: MutableList<Result>) {
        adapter.heroes = heroes.toMutableList()
    }

    private fun listener(id: Int) {
        Timber.d("CATRA")
    }
}
