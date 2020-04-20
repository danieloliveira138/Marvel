package com.danieloliveira138.marvel.presentation.details

import android.content.Context
import com.danieloliveira138.marvel.model.Request
import com.danieloliveira138.marvel.model.Status.SUCCESS
import com.danieloliveira138.marvel.model.Status.ERROR
import com.danieloliveira138.marvel.presentation.BaseViewModel
import com.danieloliveira138.marvel.usecase.HeroUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class DetailsViewModel(
    context: Context,
    private val heroUseCase: HeroUseCase
) : BaseViewModel(context) {

    fun fetchData(id: Int) {
        scope.launch {
            val request = heroUseCase.execute(Request(id = id))

            when(request.status) {
                SUCCESS -> {
                    Timber.d("CATRA\n${request.data?.data?.results?.first()}")
                }
                ERROR -> {
                    Timber.d("CATRA ERROR\n${request.message}\n${request.exception}")
                }
            }

        }
    }
}