package com.danieloliveira138.marvel.service

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Resource
import com.danieloliveira138.marvel.service.remote.HeroesService
import com.danieloliveira138.marvel.service.remote.createApiParams
import retrofit2.HttpException
import java.lang.Exception

class RepositoryImpl(
    private val service: HeroesService
) : Repository {

    override suspend fun getHeroes(offset: Int, searchQuery: String): Resource<MarvelResponse> {
        try {
            return Resource.sucess(
                with(createApiParams()) {
                    service.getCharacters(
                        this.timeStamp,
                        this.apiKey,
                        this.md5Hash,
                        searchQuery,
                        10,
                        offset
                    )
                }
            )
        } catch (exception: HttpException) {
            return Resource.error("Error", exception)
        }

    }
}