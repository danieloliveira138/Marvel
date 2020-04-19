package com.danieloliveira138.marvel.service

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.service.remote.HeroesService
import com.danieloliveira138.marvel.service.remote.createApiParams

class Repository(
    private val service: HeroesService
) {

    suspend fun getHeroes(
        offset: Int,
        searchQuery: String = ""
    ): MarvelResponse? {
        val apiParams = createApiParams()
        return service.getCharacters(
            apiParams.timeStamp,
            apiParams.apiKey,
            apiParams.md5Hash,
            searchQuery,
            10,
            offset
        )
    }
}