package com.youthtech.rhythmify.data.network.dto

data class YoutubeSearchResponse(
    val kind: String,
    val etag: String,
    val regionCode: String,
    val pageInfo: com.youthtech.rhythmify.data.network.dto.PageInfo,
    val items: List<com.youthtech.rhythmify.data.network.dto.YoutubeSearchItem>,
)

data class PageInfo(
    val totalResults: Long,
    val resultsPerPage: Long,
)

data class YoutubeSearchItem(
    val kind: String,
    val etag: String,
    val id: com.youthtech.rhythmify.data.network.dto.Id,
)

data class Id(
    val kind: String,
    val videoId: String,
)
