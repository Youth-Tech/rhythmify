package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingSongLyricsResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingSongLyricsData,
    val timestamp: Long,
)

data class ZingSongLyricsData(
    val sentences: List<com.youthtech.rhythmify.data.network.dto.Sentence>,
    val file: String,
    val enabledVideoBG: Boolean,
    val streamingUrl: String,
    val defaultIBGUrls: List<String>,
    @SerializedName("BGMode")
    val bgmMode: Long,
)

data class Sentence(
    val words: List<com.youthtech.rhythmify.data.network.dto.Word>,
)

data class Word(
    val startTime: Long,
    val endTime: Long,
    val data: String,
)
