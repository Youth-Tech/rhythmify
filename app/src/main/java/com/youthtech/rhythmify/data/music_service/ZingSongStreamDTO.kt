package com.youthtech.rhythmify.data.music_service

data class ZingSongStreamResponse(
    val err: Number,
    val msg: String,
    val timestamp: Long,
    val data: Map<String, String>
)
