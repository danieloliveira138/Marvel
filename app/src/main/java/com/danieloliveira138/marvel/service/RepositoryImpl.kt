package com.danieloliveira138.marvel.service

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Resource
import com.danieloliveira138.marvel.model.ResponseHandler
import com.danieloliveira138.marvel.service.remote.HeroesService
import com.danieloliveira138.marvel.service.remote.createApiParams
import retrofit2.HttpException

class RepositoryImpl(
    private val service: HeroesService
) : Repository {

    private val handlerResponse: ResponseHandler = ResponseHandler()

    override suspend fun getHeroes(offset: Int, searchQuery: String): Resource<MarvelResponse> {
        return try {
            handlerResponse.handleSuccess(
                with(createApiParams()) {
                    service.getCharacters(
                        this.ts,
                        this.apiKey,
                        this.md5Hash,
                        searchQuery,
                        10,
                        offset
                    )
                }
            )
        } catch (exception: HttpException) {
            return handlerResponse.handleException(exception)
        }
    }
}