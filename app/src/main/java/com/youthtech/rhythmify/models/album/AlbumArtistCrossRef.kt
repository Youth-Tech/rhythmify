package com.youthtech.rhythmify.models.album

import androidx.room.Entity

@Entity(primaryKeys = ["albumId","artistId"])
class AlbumArtistCrossRef (
    val albumId: String,
    val artistId: String
)