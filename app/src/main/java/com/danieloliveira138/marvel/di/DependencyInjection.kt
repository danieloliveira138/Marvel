package com.danieloliveira138.marvel.di

import com.danieloliveira138.marvel.presentation.details.DetailsViewModel
import com.danieloliveira138.marvel.presentation.main.MainViewModel
import com.danieloliveira138.marvel.service.Repository
import com.danieloliveira138.marvel.service.RepositoryImpl
import com.danieloliveira138.marvel.service.remote.RetrofitConfig
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    single { RetrofitConfig().service() }

    single<Repository> { RepositoryImpl(get()) }

}

val viewModelModule: Module = module {

    viewModel { MainViewModel(get(), get()) }

    viewModel { DetailsViewModel(get()) }

}