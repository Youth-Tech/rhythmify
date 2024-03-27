package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingPlaylistResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingPlaylistData,
    val timestamp: Long,
)

data class ZingPlaylistData(
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
    val distributor: String,
    val description: String,
    val aliasTitle: String,
    val sectionId: String,
    val contentLastUpdate: Long,
    val artist: com.youthtech.rhythmify.data.network.dto.Artist,
    val genres: List<com.youthtech.rhythmify.data.network.dto.Genre>,
    val song: com.youthtech.rhythmify.data.network.dto.SongPlaylist,
    val like: Long,
    val listen: Long,
    val liked: Boolean,
)

data class SongPlaylist(
    val items: List<com.youthtech.rhythmify.data.network.dto.Song>,
    val total: Long,
    val totalDuration: Long,
)
