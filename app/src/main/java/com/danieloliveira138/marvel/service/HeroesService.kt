package com.danieloliveira138.marvel.service

import com.danieloliveira138.marvel.model.MarvelApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroesService {

    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("orderBy") order: String? = "",
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): MarvelApiResponse

    @GET("/v1/public/characters/{characterId}")
    fun getCharacter(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): MarvelApiResponse

}