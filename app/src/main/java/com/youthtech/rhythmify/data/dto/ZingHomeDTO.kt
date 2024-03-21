package com.youthtech.rhythmify.data.dto

import com.google.gson.annotations.SerializedName

data class ZingHomeResponse(
    val err: Long,
    val msg: String,
    val data: Data,
    val timestamp: Long,
)

data class Data(
    val items: List<Item>,
    val hasMore: Boolean,
    val total: Long,
)

data class Item(
    val sectionType: String,
    val viewType: String?,
    val title: String?,
    val link: String?,
    val sectionId: String?,
    val items: Any?,
    val itemType: String?,
    val options: Options?,
    val banner: String?,
    val type: String?,
    val promotes: List<Promote>?,
    val chart: Chart?,
    val chartType: String?,
)

data class Options(
    val autoSlider: Boolean?,
    val hideArrow: Boolean?,
    val hideTitle: Boolean?,
)

data class Promote(
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
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: Album,
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

data class Artist(
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val thumbnail: String,
    val thumbnailM: String,
    @SerializedName("isOA")
    val isOa: Boolean,
    @SerializedName("isOABrand")
    val isOabrand: Boolean,
    val playlistId: String,
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
    val artists: List<Artist2>,
    val artistsNames: String,
)

data class Artist2(
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val thumbnail: String,
    val thumbnailM: String,
    @SerializedName("isOA")
    val isOa: Boolean,
    @SerializedName("isOABrand")
    val isOabrand: Boolean,
    val playlistId: String,
    val totalFollow: Long,
)

data class PreviewInfo(
    val startTime: Long,
    val endTime: Long,
)

data class Chart(
    val times: List<Time>,
    val minScore: Long,
    val maxScore: Double,
    val items: Map<String, List<Items>>,
    val totalScore: Long,
)

data class Time(
    val hour: String,
)

data class Items(
    val time: Long,
    val hour: String,
    val counter: Long,
)
