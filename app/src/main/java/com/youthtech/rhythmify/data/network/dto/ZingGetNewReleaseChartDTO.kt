package com.youthtech.rhythmify.data.network.dto

data class ZingGetNewReleaseChartResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingGetNewReleaseChartData,
    val timestamp: Long,
)

data class ZingGetNewReleaseChartData(
    val banner: String,
    val type: String,
    val link: String,
    val title: String,
    val sectionType: String,
    val sectionId: String,
    val viewType: String,
    val items: List<com.youthtech.rhythmify.data.network.dto.NewReleaseChartItem>,
)

data class NewReleaseChartItem(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<com.youthtech.rhythmify.data.network.dto.Artist>,
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
    val album: com.youthtech.rhythmify.data.network.dto.Album,
    val distributor: String,
    val indicators: List<String>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean?,
    val rakingStatus: Long,
    val releasedAt: Long,
    val previewInfo: com.youthtech.rhythmify.data.network.dto.PreviewInfo?,
    val mvlink: String?,
    val downloadPrivileges: List<Long>?,
)





