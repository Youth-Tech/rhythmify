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
