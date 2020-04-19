package com.danieloliveira138.marvel.service.remote

import com.danieloliveira138.marvel.model.MarvelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroesService {

    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("timeStamp") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("orderBy") order: String? = "",
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): MarvelResponse?

    @GET("/v1/public/characters/{characterId}")
    fun getCharacter(
        @Path("characterId") characterId: String,
        @Query("timeStamp") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): MarvelResponse?

}