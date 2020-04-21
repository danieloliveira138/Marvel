package com.danieloliveira138.marvel.presentation.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.danieloliveira138.marvel.extensions.toResultList
import com.danieloliveira138.marvel.model.Request
import com.danieloliveira138.marvel.model.Result
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

    val heroes: MutableLiveData<MutableList<Result>> = MutableLiveData()

    fun fetchData(offset: Int = 0) {
        scope.launch {
            val response = heroesUseCase.execute(Request(offset = offset))

            when (response.status) {
                SUCCESS -> {
                    Timber.d("CATRA\n${response.toResultList()}")
                    heroes.postValue(response.toResultList())
                }
                ERROR -> {
                    Timber.d("CATRA ERROR\n${response.message}\n${response.exception}")
                }
            }
        }
    }
}