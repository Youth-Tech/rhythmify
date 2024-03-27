package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName;

data class ZingGetHomeChartResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingGetHomeChartData,
    val timestamp: Long,
)

data class ZingGetHomeChartData(
    @SerializedName("RTChart")
    val rtchart: com.youthtech.rhythmify.data.network.dto.Rtchart,
    val newRelease: List<com.youthtech.rhythmify.data.network.dto.NewRelease>,
    val weekChart: Map<String, com.youthtech.rhythmify.data.network.dto.WeekChart>,
)

data class Rtchart(
    val promotes: List<com.youthtech.rhythmify.data.network.dto.Promote>,
    val items: List<com.youthtech.rhythmify.data.network.dto.HomeChartItem>,
    val chart: com.youthtech.rhythmify.data.network.dto.Chart,
    val chartType: String,
    val sectionType: String,
    val sectionId: String,
)

data class HomeChartItem(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<com.youthtech.rhythmify.data.network.dto.Artist>,
    val isWorldWide: Boolean,
    val previewInfo: com.youthtech.rhythmify.data.network.dto.PreviewInfo?,
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
    val hasLyric: Boolean?,
    val rakingStatus: Long,
    val score: Long,
    val totalTopZing: Long,
    val artist: com.youthtech.rhythmify.data.network.dto.Artist?,
    val downloadPrivileges: List<Long>?,
    val mvlink: String?,
)

data class NewRelease(
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
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val previewInfo: com.youthtech.rhythmify.data.network.dto.PreviewInfo?,
    val mvlink: String?,
    val downloadPrivileges: List<Long>?,
)

data class WeekChart(
    val banner: String,
    val playlistId: String,
    val chartId: Long,
    val cover: String,
    val country: String,
    val type: String,
    val group: List<com.youthtech.rhythmify.data.network.dto.WeekChartGroup>,
    // get id param for the getWeekChart function base on this field
    // ex: /zing-chart-tuan/Bai-hat-Viet-Nam/IWZ9Z08I.html
    val link: String,
    val week: Long,
    val year: Long,
    val latestWeek: Long,
    val startDate: String,
    val endDate: String,
    val items: List<com.youthtech.rhythmify.data.network.dto.WeekChartItem>,
    val sectionId: String,
)

data class WeekChartGroup(
    val id: Long,
    val name: String,
    val type: String,
    val link: String,
)