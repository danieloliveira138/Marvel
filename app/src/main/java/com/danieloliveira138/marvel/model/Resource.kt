package com.danieloliveira138.marvel.model

import com.danieloliveira138.marvel.model.Status.SUCCESS
import com.danieloliveira138.marvel.model.Status.ERROR
import com.danieloliveira138.marvel.model.Status.LOADING
import retrofit2.HttpException

data class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val exception: HttpException? = null
) {

    companion object {
        fun <T> sucess(data: T?): Resource<T> = Resource(SUCCESS, data)
        fun <T> error(message: String, exception: HttpException): Resource<T> = Resource(ERROR, exception = exception)
        fun <T> loading(data: T?): Resource<T> = Resource(LOADING, data)
    }
}

enum class Status {
    SUCCESS, ERROR, LOADING
}