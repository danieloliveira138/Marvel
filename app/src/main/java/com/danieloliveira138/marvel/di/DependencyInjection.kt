package com.danieloliveira138.marvel.di

import com.danieloliveira138.marvel.presentation.details.DetailsViewModel
import com.danieloliveira138.marvel.presentation.main.MainViewModel
import com.danieloliveira138.marvel.presentation.main.heroslist.HeroesAdapter
import com.danieloliveira138.marvel.service.Repository
import com.danieloliveira138.marvel.service.RepositoryImpl
import com.danieloliveira138.marvel.service.remote.RetrofitConfig
import com.danieloliveira138.marvel.usecase.HeroUseCase
import com.danieloliveira138.marvel.usecase.HeroesUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    single { RetrofitConfig().service() }

    single<Repository> { RepositoryImpl(get()) }

    single { HeroesUseCase(get()) }

    single { HeroUseCase(get()) }

    factory { (listener: (Int) -> Unit) ->
        HeroesAdapter(listener)
    }
}

val viewModelModule: Module = module {

    viewModel { MainViewModel(get(), get()) }

    viewModel { DetailsViewModel(get(), get()) }

}