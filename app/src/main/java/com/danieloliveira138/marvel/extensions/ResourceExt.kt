package com.danieloliveira138.marvel.extensions

import com.danieloliveira138.marvel.model.MarvelResponse
import com.danieloliveira138.marvel.model.Resource
import com.danieloliveira138.marvel.model.Result

fun Resource<MarvelResponse>.toResultList(): MutableList<Result>? {
    this.data?.data?.results?.let {
        if (it.isNotEmpty()) return it as MutableList
    }
    return null
}

fun Resource<MarvelResponse>.toResult(): Result? {
    return this.data?.data?.results?.firstOrNull()
}