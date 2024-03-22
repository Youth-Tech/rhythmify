package com.youthtech.rhythmify.data.dto

data class ZingSongStreamResponse(
    val err: Number,
    val msg: String,
    val timestamp: Long,
    val data: Map<String, String>
)