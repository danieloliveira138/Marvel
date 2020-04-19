package com.danieloliveira138.marvel.model

import com.danieloliveira138.marvel.model.Status.*

data class Resource<T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> sucess(data: T?): Resource<T> = Resource(SUCCESS, data, null)
        fun <T> error(message: String, data: T?): Resource<T> = Resource(ERROR, data, message)
        fun <T> loading(data: T?): Resource<T> = Resource(LOADING, data, null)
    }
}

enum class Status {
    SUCCESS, ERROR, LOADING
}