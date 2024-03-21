package com.youthtech.rhythmify.utils

import kotlin.math.floor

object Commons {
    val currentTime = floor(System.currentTimeMillis().toDouble() / 1000).toInt().toString()
}