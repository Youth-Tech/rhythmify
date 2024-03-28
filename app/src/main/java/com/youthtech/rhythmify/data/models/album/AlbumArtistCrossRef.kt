package com.youthtech.rhythmify.data.models.album

import androidx.room.Entity

@Entity(
    tableName = "album_artist_cross_ref",
    primaryKeys = ["albumId","artistId"]
)
class AlbumArtistCrossRef (
    val albumId: String,
    val artistId: String
)