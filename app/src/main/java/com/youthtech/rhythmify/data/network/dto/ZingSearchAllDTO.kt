package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ZingSearchAllResponse(
    val err: Long,
    val msg: String,
    val data: ZingSearchAllData,
    val timestamp: Long,
)

data class ZingSearchAllData(
    val top: Top,
    val artists: List<Artist>,
    val songs: List<Song>,
    val videos: List<Video>,
    val playlists: List<Playlist>,
    val counter: Counter,
    val sectionId: String,
)

data class Top(
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val playlistId: String,
    val cover: String,
    val thumbnail: String,
    val objectType: String,
)

data class Video(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<Artist>,
    val isWorldWide: Boolean,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val streamingStatus: Long,
    val artist: Artist,
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
    val isOwner: Boolean,
    val canEdit: Boolean,
    val canDelete: Boolean,
)

data class Counter(
    val song: Long,
    val artist: Long,
    val playlist: Long,
    val video: Long,
)
