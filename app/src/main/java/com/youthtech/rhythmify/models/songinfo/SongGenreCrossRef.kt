package com.youthtech.rhythmify.models.songinfo
import androidx.room.Entity

@Entity(primaryKeys = ["songId", "genreId"])
data class SongGenreCrossRef(
    val songId: String,
    val genreId: String
)