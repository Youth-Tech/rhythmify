package com.youthtech.rhythmify.data.network.dto

class ZingGetSectionSongStationResponse(
    val err: Long,
    val msg: String,
    val data: com.youthtech.rhythmify.data.network.dto.SongStationData,
    val timestamp: Long,
)

data class SongStationData(
    val items: List<com.youthtech.rhythmify.data.network.dto.Song>,
)
