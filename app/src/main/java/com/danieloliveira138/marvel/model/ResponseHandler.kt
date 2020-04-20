package com.danieloliveira138.marvel.model

import okhttp3.internal.http2.ErrorCode
import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException

open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> = Resource.sucess(data)

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when(e) {
            is HttpException -> Resource.error(getErrorMessage(e.code()), e)
            is SocketTimeoutException -> Resource.error(getErrorMessage(ErrorCode.SETTINGS_TIMEOUT.httpCode), e)
            else -> Resource.error(getErrorMessage(Int.MAX_VALUE), e)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when(code) {
            ErrorCode.SETTINGS_TIMEOUT.httpCode -> "TimeOut"
            401 -> "Unauthorised"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}