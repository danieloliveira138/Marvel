package com.danieloliveira138.marvel.presentation.main

import android.content.Context
import com.danieloliveira138.marvel.model.Request
import com.danieloliveira138.marvel.model.Status.SUCCESS
import com.danieloliveira138.marvel.model.Status.ERROR
import com.danieloliveira138.marvel.presentation.BaseViewModel
import com.danieloliveira138.marvel.usecase.HeroesUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    context: Context,
    private val heroesUseCase: HeroesUseCase
) : BaseViewModel(context) {

    fun fetchData() {
        scope.launch {
            val response = heroesUseCase.execute(Request(offset = 0))

            when (response.status) {
                SUCCESS -> {
                    Timber.d("CATRA\n${response.data}")
                }
                ERROR -> {
                    Timber.d("CATRA ERROR\n${response.message}\n${response.exception}")
                }
            }
        }
    }
}