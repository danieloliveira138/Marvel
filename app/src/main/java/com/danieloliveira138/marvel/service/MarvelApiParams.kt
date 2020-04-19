package com.danieloliveira138.marvel.service

import cc.duduhuo.util.digest.Digest
import com.danieloliveira138.marvel.model.ApiParams
import java.util.Calendar

fun createApiParams(): ApiParams {
    val timeInMillis = Calendar.getInstance().timeInMillis.toString()
    val privateKey = PRIVATE_KEY
    val publicKey = PUBLIC_KEY

    return ApiParams(
        ts = timeInMillis,
        key = publicKey,
        md5Hash = Digest.md5Hex("$timeInMillis$privateKey$publicKey")
    )
}