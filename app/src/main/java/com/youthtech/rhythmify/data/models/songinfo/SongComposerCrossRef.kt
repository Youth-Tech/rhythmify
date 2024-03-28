package com.youthtech.rhythmify.data.models.songinfo

import androidx.room.Entity

@Entity(
    tableName = "song_composer_cross_ref",
    primaryKeys = ["songId", "composerId"]
)
data class SongComposerCrossRef(
    val songId: String,
    val composerId: String
)