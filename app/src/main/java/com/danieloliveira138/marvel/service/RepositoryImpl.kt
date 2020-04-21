package com.danieloliveira138.marvel.service

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Resource
import com.danieloliveira138.marvel.model.ResponseHandler
import com.danieloliveira138.marvel.service.remote.HeroesService
import com.danieloliveira138.marvel.service.remote.createApiParams
import java.lang.Exception

class RepositoryImpl(
    private val service: HeroesService
) : Repository {

    private val handlerResponse: ResponseHandler = ResponseHandler()

    override suspend fun getHeroes(
        offset: Int,
        limit: Int,
        searchQuery: String
    ): Resource<MarvelResponse> {
        return try {
            handlerResponse.handleSuccess(
                with(createApiParams()) {
                    service.getCharacters(
                        this.ts,
                        this.apiKey,
                        this.md5Hash,
                        searchQuery,
                        limit,
                        offset
                    )
                }
            )
        } catch (exception: Exception) {
            handlerResponse.handleException(exception)
        }
    }

    override suspend fun getHero(characterId: String): Resource<MarvelResponse> {
        return try {
            handlerResponse.handleSuccess(
                with(createApiParams()) {
                    service.getCharacter(
                        characterId,
                        this.ts,
                        this.apiKey,
                        this.md5Hash
                    )
                }
            )
        } catch (exception: Exception) {
            handlerResponse.handleException(exception)
        }
    }
}