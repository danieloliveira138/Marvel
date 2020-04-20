package com.danieloliveira138.marvel.presentation.main

import android.content.Context
import android.util.Log
import com.danieloliveira138.marvel.model.Status
import com.danieloliveira138.marvel.presentation.BaseViewModel
import com.danieloliveira138.marvel.service.Repository
import kotlinx.coroutines.launch

class MainViewModel(
    private val context: Context,
    private val repository: Repository) : BaseViewModel(context) {

    fun fetchData() {
        scope.launch {
            val response = repository.getHeroes(0)

            when (response.status) {
                Status.SUCCESS -> {
                    Log.d("CATRA","${response.data}")
                }
                Status.ERROR -> {
                    Log.d("CATRA ERROR", "\n${response.message}\n${response.exception}")
                }
            }
        }
    }
}