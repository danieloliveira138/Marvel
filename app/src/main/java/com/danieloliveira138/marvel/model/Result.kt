package com.danieloliveira138.marvel.model

data class Result(
    val comics: Content? = null,
    val description: String = "",
    val events: Content? = null,
    val id: Int = 0,
    val modified: String = "",
    val name: String = "",
    val resourceURI: String = "",
    val series: Content? = null,
    val stories: Content? = null,
    val thumbnail: Thumbnail = Thumbnail(),
    val urls: List<Url> = listOf()
)
