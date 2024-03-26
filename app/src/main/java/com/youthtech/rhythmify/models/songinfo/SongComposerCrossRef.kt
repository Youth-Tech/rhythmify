package com.youthtech.rhythmify.models.songinfo

import androidx.room.Entity

@Entity(primaryKeys = ["songId", "composerId"])
data class SongComposerCrossRef (
    val songId: String,
    val composerId: String
)