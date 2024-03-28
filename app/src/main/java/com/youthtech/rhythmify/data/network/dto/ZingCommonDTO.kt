package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName

data class ArtistDTO(
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

data class AlbumDTO(
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
    val artists: List<ArtistDTO>,
    val artistsNames: String,
)

data class GenreDTO(
    val id: String,
    val name: String,
    val title: String,
    val alias: String,
    val link: String,
)

data class ComposerDTO(
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
//    val playlistId: String,
    val cover: String,
    val thumbnail: String,
    val totalFollow: Long,
)

data class PreviewInfo(
    val startTime: Long,
    val endTime: Long,
)

data class SongDTO(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<ArtistDTO>,
    val isWorldWide: Boolean,
    val previewInfo: PreviewInfo?,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: AlbumDTO?,
    val distributor: String,
    val indicators: List<String>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val downloadPrivileges: List<Long>?,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean?,
    val mvlink: String?,
    val streamPrivileges: List<Long>?,
    val radioId: Long?,
)

data class Promote(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<ArtistDTO>,
    val isWorldWide: Boolean,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: AlbumDTO,
    val distributor: String,
    val indicators: List<String>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val previewInfo: PreviewInfo?,
    val downloadPrivileges: List<Long>?,
    val streamPrivileges: List<Long>?,
    val mvlink: String?,
)

data class Chart(
    val times: List<ChartTime>,
    val minScore: Long,
    val maxScore: Double,
    val items: Map<String, List<ChartItem>>,
    val totalScore: Long,
)

data class ChartItem(
    val time: Long,
    val hour: String,
    val counter: Long,
)

data class ChartTime(
    val hour: String,
)
