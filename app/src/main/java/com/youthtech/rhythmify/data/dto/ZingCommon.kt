package com.youthtech.rhythmify.data.dto

import com.google.gson.annotations.SerializedName

data class Artist (
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val thumbnail: String,
    val thumbnailM: String?,
    val isOA: Boolean?,
    val isOABrand: Boolean?,
    val playlistId: String?,
    val totalFollow: Long?,
)
data class Album(
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
    val artists: List<Artist>,
    val artistsNames: String,
)

data class Genre(
    val id: String,
    val name: String,
    val title: String,
    val alias: String,
    val link: String,
)

data class Composer(
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val playlistId: String,
    val cover: String,
    val thumbnail: String,
    val totalFollow: Long,
)

data class PreviewInfo(
    val startTime: Long,
    val endTime: Long,
)

data class Group(
    val id: Long,
    val name: String,
    val type: String,
    val link: String,
)
data class Time(
    val hour: String,
)

data class Program(
    val id: Long?,
    val encodeId: String,
    val title: String,
    val thumbnail: String,
    val thumbnailH: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val hasSongRequest: Boolean,
    val genreIds: List<String>?,
)

data class Host(
    val name: String,
    val encodeId: String,
    val thumbnail: String,
    val link: String,
)

data class Playlist(
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
