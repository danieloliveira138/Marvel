package com.danieloliveira138.marvel.service.remote

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.concurrent.TaskRunner.Companion.logger

class MarvelInterceptor(private val intercept: Boolean) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return if (intercept) interceptResponse(chain) else chain.proceed(chain.request())
    }

    private fun interceptResponse(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val timeAtRequest = System.nanoTime()
        val response = chain.proceed(request)
        val timeAtResponse = System.nanoTime()

        logger.info("Sending request ${chain.request().url}\n" +
                "on ${chain.connection()}\n ${request.headers}")

        logger.info("Receiver response for ${chain.request().url}\n" +
                "TIME: ${timeAtRequest - timeAtResponse}\n" +
                "HEADERS: ${response.headers}\n" +
                "BODY: ${response.body}")

        return response
    }
}