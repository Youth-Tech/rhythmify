package com.youthtech.rhythmify.data.dto

data class ZingHomeResponse(
    val err: Long,
    val msg: String,
    val data: ZingHomeData,
    val timestamp: Long,
)

data class ZingHomeData(
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


data class Chart(
    val times: List<Time>,
    val minScore: Long,
    val maxScore: Double,
    val items: Map<String, List<Items>>,
    val totalScore: Long,
)



data class Items(
    val time: Long,
    val hour: String,
    val counter: Long,
)
