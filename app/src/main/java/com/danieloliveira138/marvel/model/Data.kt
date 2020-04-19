package com.danieloliveira138.marvel.model

data class Data(
    val count: Int = 0,
    val limit: Int = 0,
    val offset: Int = 0,
    val results: List<Result> = listOf(),
    val total: Int = 0
)