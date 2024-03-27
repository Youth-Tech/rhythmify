package com.youthtech.rhythmify.data.network.dto

data class ZingGetHubHomeResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingGetHubHomeData,
    val timestamp: Long,
)

data class ZingGetHubHomeData(
    val banners: List<com.youthtech.rhythmify.data.network.dto.Banner>,
    val featured: com.youthtech.rhythmify.data.network.dto.Featured,
    val topTopic: List<com.youthtech.rhythmify.data.network.dto.TopTopic>,
    val topic: List<com.youthtech.rhythmify.data.network.dto.Topic>,
    val nations: List<com.youthtech.rhythmify.data.network.dto.Nation>,
    val genre: List<com.youthtech.rhythmify.data.network.dto.Genre>,
    val sectionId: String,
)

data class Banner(
    val cover: String,
    val link: String,
)

data class Featured(
    val title: String,
    val items: List<com.youthtech.rhythmify.data.network.dto.ZingGetHubHomeItem>,
)

data class ZingGetHubHomeItem(
    val encodeId: String,
    val cover: String,
    val thumbnail: String,
    val thumbnailHasText: String,
    val thumbnailR: String,
    val title: String,
    val link: String,
    val description: String,
)

data class TopTopic(
    val encodeId: String,
    val cover: String,
    val thumbnail: String,
    val thumbnailHasText: String,
    val thumbnailR: String,
    val title: String,
    val link: String,
    val description: String,
    val playlists: List<com.youthtech.rhythmify.data.network.dto.Playlist>,
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
    val playlists: List<com.youthtech.rhythmify.data.network.dto.Playlist>,
)


data class Nation(
    val encodeId: String,
    val cover: String,
    val thumbnail: String,
    val thumbnailHasText: String,
    val thumbnailR: String,
    val title: String,
    val link: String,
    val description: String,
)



