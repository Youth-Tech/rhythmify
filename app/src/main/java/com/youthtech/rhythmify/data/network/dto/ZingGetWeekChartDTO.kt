package com.youthtech.rhythmify.data.network.dto


data class ZingGetWeekChartResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingGetWeekChartData,
    val timestamp: Long,
)

data class ZingGetWeekChartData(
    val banner: String,
    val playlistId: String,
    val chartId: Long,
    val cover: String,
    val country: String,
    val type: String,
    val group: List<com.youthtech.rhythmify.data.network.dto.WeekChartGroup>,
    val link: String,
    val week: Long,
    val year: Long,
    val latestWeek: Long,
    val startDate: String,
    val endDate: String,
    val items: List<com.youthtech.rhythmify.data.network.dto.WeekChartItem>,
    val sectionId: String,
)

data class WeekChartItem(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<com.youthtech.rhythmify.data.network.dto.Artist>,
    val isWorldWide: Boolean,
    val previewInfo: com.youthtech.rhythmify.data.network.dto.PreviewInfo,
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
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val rakingStatus: Long,
    val score: Long,
    val downloadPrivileges: List<Long>?,
    val mvlink: String?,
)




