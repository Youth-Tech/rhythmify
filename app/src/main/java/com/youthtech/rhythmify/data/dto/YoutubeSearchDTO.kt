package com.youthtech.rhythmify.data.dto

data class YoutubeSearchResponse(
    val kind: String,
    val etag: String,
    val regionCode: String,
    val pageInfo: PageInfo,
    val items: List<YoutubeSearchItem>,
)

data class PageInfo(
    val totalResults: Long,
    val resultsPerPage: Long,
)

data class YoutubeSearchItem(
    val kind: String,
    val etag: String,
    val id: Id,
)

data class Id(
    val kind: String,
    val videoId: String,
)
