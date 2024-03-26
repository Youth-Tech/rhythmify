package com.youthtech.rhythmify.models.songinfo

import androidx.room.Entity

@Entity(primaryKeys = ["encodeId", "id"])
data class SongArtistCrossRef (
    val encodeId: String,
    val id: String
)