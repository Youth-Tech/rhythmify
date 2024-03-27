package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingSuggestPlaylistResponse(
    val err: Long,
    val msg: String,
    val data: List<com.youthtech.rhythmify.data.network.dto.ZingSuggestPlaylistData>,
    val timestamp: Long,
)

data class ZingSuggestPlaylistData(
    val sectionType: String,
    val viewType: String?,
    val title: String?,
    val link: String?,
    val sectionId: String?,
    val items: List<com.youthtech.rhythmify.data.network.dto.ZingSuggestPlaylistDataItem>?,
    val adId: String?,
    val pageType: String?,
)

data class ZingSuggestPlaylistDataItem(
    val id: String?,
    val name: String?,
    val link: String,
    val spotlight: Boolean?,
    val alias: String?,
    val playlistId: String?,
    val cover: String?,
    val thumbnail: String,
    val totalFollow: Long?,
    val encodeId: String?,
    val title: String?,
    val isoffical: Boolean?,
    val isIndie: Boolean?,
    val releaseDate: String?,
    val sortDescription: String?,
    val releasedAt: Long?,
    val genreIds: List<String>?,
    @SerializedName("PR")
    val pr: Boolean?,
    val artists: List<com.youthtech.rhythmify.data.network.dto.Artist>?,
    val artistsNames: String?,
    val playItemMode: Long?,
    val subType: Long?,
    val uid: Long?,
    val thumbnailM: String?,
    val isShuffle: Boolean?,
    val isPrivate: Boolean?,
    val userName: String?,
    val isAlbum: Boolean?,
    val textType: String?,
    val isSingle: Boolean?,
)
