package com.youthtech.rhythmify.data.dto

data class ZingGetRecommendKeywordResponse(
    val err: Long,
    val msg: String,
    val data: List<ZingKeyword>,
    val timestamp: Long,
)

data class ZingKeyword(
    val keyword: String,
    val link: String,
)
