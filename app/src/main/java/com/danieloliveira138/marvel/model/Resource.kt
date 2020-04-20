package com.danieloliveira138.marvel.model

import com.danieloliveira138.marvel.model.Status.SUCCESS
import com.danieloliveira138.marvel.model.Status.ERROR

data class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val exception: Exception? = null
) {

    companion object {
        fun <T> sucess(data: T?): Resource<T> = Resource(SUCCESS, data)
        fun <T> error(message: String, exception: Exception): Resource<T> =
            Resource(ERROR, message = message, exception = exception)
    }
}

enum class Status { SUCCESS, ERROR }