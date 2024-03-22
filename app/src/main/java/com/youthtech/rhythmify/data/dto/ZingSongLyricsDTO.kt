package com.youthtech.rhythmify.data.dto

import com.google.gson.annotations.SerializedName

data class ZingSongLyricsResponse(
    val err: Long,
    val msg: String,
    val data: ZingSongLyricsData,
    val timestamp: Long,
)

data class ZingSongLyricsData(
    val sentences: List<Sentence>,
    val file: String,
    val enabledVideoBG: Boolean,
    val streamingUrl: String,
    val defaultIBGUrls: List<String>,
    @SerializedName("BGMode")
    val bgmMode: Long,
)

data class Sentence(
    val words: List<Word>,
)

data class Word(
    val startTime: Long,
    val endTime: Long,
    val data: String,
)
