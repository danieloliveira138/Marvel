package com.danieloliveira138.marvel.service.remote

import com.danieloliveira138.marvel.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private val client = OkHttpClient()
        .newBuilder()
        .addInterceptor(MarvelInterceptor(BuildConfig.DEBUG))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun service(): HeroesService = retrofit.create<HeroesService>(HeroesService::class.java)
}