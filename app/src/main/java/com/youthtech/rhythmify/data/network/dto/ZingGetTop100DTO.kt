package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingGetTop100Response(
    val err: Long,
    val msg: String,
    val data: List<com.youthtech.rhythmify.data.network.dto.ZingGetTop100Data>,
    val timestamp: Long,
)

data class ZingGetTop100Data(
    val sectionType: String,
    val viewType: String,
    val title: String,
    val link: String,
    val sectionId: String,
    val items: List<com.youthtech.rhythmify.data.network.dto.ZingGetTop100Item>,
    val genre: com.youthtech.rhythmify.data.network.dto.Genre,
)

data class ZingGetTop100Item(
    val encodeId: String,
    val title: String,
    val thumbnail: String,
    val isoffical: Boolean,
    val link: String,
    val isIndie: Boolean,
    val releaseDate: String,
    val sortDescription: String,
    val releasedAt: Long,
    val genreIds: List<String>,
    @SerializedName("PR")
    val pr: Boolean,
    val artists: List<com.youthtech.rhythmify.data.network.dto.Artist>,
    val artistsNames: String,
    val playItemMode: Long,
    val subType: Long,
    val uid: Long,
    val thumbnailM: String,
    val isShuffle: Boolean,
    val isPrivate: Boolean,
    val userName: String,
    val isAlbum: Boolean,
    val textType: String,
    val isSingle: Boolean,
)



