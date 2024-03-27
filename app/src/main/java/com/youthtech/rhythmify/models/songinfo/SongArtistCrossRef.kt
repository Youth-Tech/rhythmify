package com.youthtech.rhythmify.models.songinfo

import androidx.room.Entity

@Entity(
    tableName = "song_artist_cross_ref",
    primaryKeys = ["songId", "artistId"],
)
data class SongArtistCrossRef (
    val songId: String,
    val artistId: String
)