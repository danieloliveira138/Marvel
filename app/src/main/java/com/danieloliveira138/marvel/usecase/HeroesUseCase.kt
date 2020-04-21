package com.danieloliveira138.marvel.usecase

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Request
import com.danieloliveira138.marvel.model.Resource
import com.danieloliveira138.marvel.service.Repository

private const val PAGE_LIMIT = 20

class HeroesUseCase(
    private val repository: Repository
) : UseCase {

    override suspend fun execute(request: Request): Resource<MarvelResponse> {
        return repository.getHeroes(request.offset + 1, PAGE_LIMIT)
    }
}