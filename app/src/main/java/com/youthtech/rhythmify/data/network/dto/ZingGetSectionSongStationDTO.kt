package com.youthtech.rhythmify.data.network.dto

class ZingGetSectionSongStationResponse(
    val err: Long,
    val msg: String,
    val data: SongStationData,
    val timestamp: Long,
)

data class SongStationData(
    val items: List<Song>,
)
