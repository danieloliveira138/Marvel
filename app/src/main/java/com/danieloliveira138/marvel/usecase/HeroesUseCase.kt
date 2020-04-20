package com.danieloliveira138.marvel.usecase

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Request
import com.danieloliveira138.marvel.model.Resource
import com.danieloliveira138.marvel.service.Repository

class HeroesUseCase(
    private val repository: Repository
) : UseCase {

    override suspend fun execute(request: Request): Resource<MarvelResponse> {
        return repository.getHeroes(request.offset)
    }
}