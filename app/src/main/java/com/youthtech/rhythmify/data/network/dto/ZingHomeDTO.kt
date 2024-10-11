package com.youthtech.rhythmify.data.network.dto

data class ZingHomeResponse(
    val err: Long,
    val msg: String,
    val data: ZingHomeData,
    val timestamp: Long,
)

data class ZingHomeData(
    val items: List<ZingHomeDataItem>,
    val hasMore: Boolean,
    val total: Long,
)

data class ZingHomeDataItem(
    val sectionType: String,
    val viewType: String?,
    val title: String?,
    val link: String?,
    val sectionId: String?,
    val items: List<ZingHomeItem>, // Use the sealed class
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
sealed class ZingHomeItem {
    data class BannerItem(val link: String, val banner: String, val title: String, val description: String) : ZingHomeItem()
    data class RecentPlaylistItem(val playlistId: String, val playlistName: String) : ZingHomeItem()
    data class NewReleaseItem(val all: List<String>) : ZingHomeItem()
    // Add more item types as needed
}

