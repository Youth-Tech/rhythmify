package com.youthtech.rhythmify.data.network.dto

data class ZingGetHubHomeResponse(
    val err: Long,
    val msg: String,
    val data: ZingGetHubHomeData,
    val timestamp: Long,
)

data class ZingGetHubHomeData(
    val banners: List<Banner>,
    val featured: Featured,
    val topTopic: List<Topic>,
    val topic: List<Topic>,
    val nations: List<BaseCategoryItem>,
    val genre: List<GenreDTO>,
    val sectionId: String,
)

data class Banner(
    val cover: String,
    val link: String,
)

data class Featured(
    val title: String,
    val items: List<BaseCategoryItem>,
)

data class BaseCategoryItem(
    val encodeId: String,
    val cover: String,
    val thumbnail: String,
    val thumbnailHasText: String,
    val thumbnailR: String,
    val title: String,
    val link: String,
    val description: String,
)

data class Topic(
    val encodeId: String,
    val cover: String,
    val thumbnail: String,
    val thumbnailHasText: String,
    val thumbnailR: String,
    val title: String,
    val link: String,
    val description: String,
    val playlists: List<Playlist>,
)




