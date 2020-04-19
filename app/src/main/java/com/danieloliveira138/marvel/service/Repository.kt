package com.danieloliveira138.marvel.service

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Resource

interface Repository {

    suspend fun getHeroes(offset: Int, searchQuery: String = "") : Resource<MarvelResponse>

}