package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingSuggestKeywordResponse(
    val err: Long,
    val msg: String,
    val sTime: Long,
    val data: ZingSuggestKeywordData,
)

data class ZingSuggestKeywordData(
    val tracking: String,
    val items: List<SuggestKeywordDataItem>,
)

data class SuggestKeywordDataItem(
    val keywords: List<Keyword>?,
    val suggestions: List<Suggestion>?,
)

data class Keyword(
    val type: Long,
    val keyword: String,
    val suggestType: Long,
)

data class Suggestion(
    val type: Long,
    val title: String,
    val id: String,
    val hasVideo: Boolean,
    val thumb: String,
    val thumbVideo: String,
    val duration: Long,
    val link: String,
    val modifiedTime: Long,
    val lyricLink: String,
    val lyricId: String,
    val downloadTypes: String,
    @SerializedName("orgMD5")
    val orgMd5: String,
    val userId: Long,
    val euId: String,
    val privacy: Long,
    val releaseTime: Long,
    val downloadStatus: Long,
    val status: Long,
    val playStatus: Long,
    val downloadPrvl: List<Long>?,
    val downloadPrvlPkgId: Long?,
    val artists: List<ArtistDTO>,
    val genres: List<GenreDTO>,
    @SerializedName("disSPlatform")
    val disSplatform: Long,
    @SerializedName("disDPlatform")
    val disDplatform: Long,
    val boolAtt: Long,
    val tracking: String,
    val radioPid: String?,
    val hLyricVersion: Long?,
    val playPrvl: List<Long>?,
    val playPrvlPkgId: Long?,
    val video: Video?,
)
