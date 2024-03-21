package com.youthtech.rhythmify.utils

import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object Crypto {
    fun hash256(str: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(str.toByteArray())
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    fun hashHmac512(str: String, key: String): String {
        val hmacKey = SecretKeySpec(key.toByteArray(), "HmacSHA512")
        val hmac = Mac.getInstance("HmacSHA512")
        hmac.init(hmacKey)
        val bytes = hmac.doFinal(str.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}