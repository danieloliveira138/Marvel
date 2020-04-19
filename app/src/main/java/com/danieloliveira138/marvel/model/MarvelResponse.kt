package com.danieloliveira138.marvel.model

data class MarvelApiResponse(
    val `data`: Data = Data(),
    val attributionHTML: String = "",
    val attributionText: String = "",
    val code: Int = 0,
    val copyright: String = "",
    val etag: String = "",
    val status: String = ""
)