package com.danieloliveira138.marvel.service

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.concurrent.TaskRunner.Companion.logger

class MarvelInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val timeAtRequest = System.nanoTime()

        logger.info("Sending request ${chain.request().url}\n" +
                "on ${chain.connection()}\n ${request.headers}")

        val response = chain.proceed(request)

        val timeAtResponse = System.nanoTime()
        logger.info("Receiver response for ${chain.request().url}\n" +
                "TIME: ${timeAtRequest - timeAtResponse}\n" +
                "HEADERS: ${response.headers}\n" +
                "BODY: ${response.body}")
        return response
    }
}