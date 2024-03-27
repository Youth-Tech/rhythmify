package com.youthtech.rhythmify.models.songinfo

import androidx.room.Entity
import androidx.room.ForeignKey
import com.youthtech.rhythmify.models.Genre
import com.youthtech.rhythmify.models.Song

@Entity(
    tableName = "song_genre_cross_ref",
    primaryKeys = ["songId", "genreId"],
)
data class SongGenreCrossRef(
    val songId: String,
    val genreId: String
)