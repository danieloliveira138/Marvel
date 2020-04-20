package com.danieloliveira138.marvel.model

data class Request(
    val offset: Int = 0,
    val id: Int = 0,
    val queryText: String = ""
)