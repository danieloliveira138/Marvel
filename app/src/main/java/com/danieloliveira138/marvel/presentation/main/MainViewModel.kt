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

            if (response.status == Status.SUCCESS) {
                val results = response.data
                Log.d("CATRA","$results")
            }
        }
    }
}