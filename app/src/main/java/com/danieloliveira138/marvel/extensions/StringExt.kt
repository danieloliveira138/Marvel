package com.danieloliveira138.marvel.extensions

fun String.toClearTextTrafficPermitted(): String {
    return this.replace("http", "https")
}