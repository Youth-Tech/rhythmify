package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingGetHubDetailResponse(
    val err: Long,
    val msg: String,
    val data: ZingGetHubDetailData,
    val timestamp: Long,
)

data class ZingGetHubDetailData(
    val encodeId: String,
    val cover: String,
    val thumbnail: String,
    val thumbnailHasText: String,
    val thumbnailR: String,
    val title: String,
    val link: String,
    val description: String,
    val sections: List<ZingHubDetailSection>,
)

data class ZingHubDetailSection(
    val sectionType: String,
    val viewType: String,
    val title: String,
    val link: String,
    val sectionId: String,
    val items: List<ZingGetHubDetailItem>,
)

data class ZingGetHubDetailItem(
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
    @SerializedName("PR") val pr: Boolean,
    val artists: List<Artist>,
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


