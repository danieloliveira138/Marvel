package com.danieloliveira138.marvel.service.remote

import cc.duduhuo.util.digest.Digest
import com.danieloliveira138.marvel.model.ApiParams
import java.util.Calendar

fun createApiParams(): ApiParams {
    val timeInMillis = Calendar.getInstance().timeInMillis.toString()
    val privateKey = PRIVATE_KEY
    val publicKey = PUBLIC_KEY

    return ApiParams(
        timeStamp = timeInMillis,
        apiKey = publicKey,
        md5Hash = Digest.md5Hex("$timeInMillis$privateKey$publicKey")
    )
}