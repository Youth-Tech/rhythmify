package com.youthtech.rhythmify.models.songinfo

import androidx.room.Entity

@Entity(primaryKeys = ["encodeId", "id"])
data class SongComposerCrossRef (
    val encodeId: String,
    val id: String
)