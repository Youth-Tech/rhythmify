package com.youthtech.rhythmify.data.network.dto

import com.google.gson.annotations.SerializedName;

data class ZingGetHomeChartResponse(
    val err: Long,
    val msg: String,
    val data: ZingGetHomeChartData,
    val timestamp: Long,
)

data class ZingGetHomeChartData(
    @SerializedName("RTChart")
    val rtchart: Rtchart,
    val newRelease: List<NewRelease>,
    val weekChart: Map<String, WeekChart>,
)

data class Rtchart(
    val promotes: List<Promote>,
    val items: List<HomeChartItem>,
    val chart: Chart,
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
    val album: AlbumDTO,
    val distributor: String,
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean?,
    val rakingStatus: Long,
    val score: Long,
    val totalTopZing: Long,
    val artist: ArtistDTO?,
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
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val previewInfo: PreviewInfo?,
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
    val group: List<WeekChartGroup>,
    // get id param for the getWeekChart function base on this field
    // ex: /zing-chart-tuan/Bai-hat-Viet-Nam/IWZ9Z08I.html
    val link: String,
    val week: Long,
    val year: Long,
    val latestWeek: Long,
    val startDate: String,
    val endDate: String,
    val items: List<WeekChartItem>,
    val sectionId: String,
)

data class WeekChartGroup(
    val id: Long,
    val name: String,
    val type: String,
    val link: String,
)