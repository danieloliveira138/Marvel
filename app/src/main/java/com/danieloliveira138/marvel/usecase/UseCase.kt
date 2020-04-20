package com.danieloliveira138.marvel.usecase

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Request
import com.danieloliveira138.marvel.model.Resource

interface UseCase {

    suspend fun execute(request: Request): Resource<MarvelResponse>
}