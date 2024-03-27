package com.youthtech.rhythmify.data.network.dto

data class ZingHomeResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.ZingHomeData,
    val timestamp: Long,
)

data class ZingHomeData(
    val items: List<com.youthtech.rhythmify.data.network.dto.ZingHomeDataItem>,
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
    val options: com.youthtech.rhythmify.data.network.dto.Options?,
    val banner: String?,
    val type: String?,
    val promotes: List<com.youthtech.rhythmify.data.network.dto.Promote>?,
    val chart: com.youthtech.rhythmify.data.network.dto.Chart?,
    val chartType: String?,
)

data class Options(
    val autoSlider: Boolean?,
    val hideArrow: Boolean?,
    val hideTitle: Boolean?,
)
