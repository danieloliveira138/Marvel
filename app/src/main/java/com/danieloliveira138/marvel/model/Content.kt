package com.danieloliveira138.marvel.model

data class Content(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<Any> = listOf(),
    val returned: Int = 0
)