package com.youthtech.rhythmify.data.models.album

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.youthtech.rhythmify.data.models.Album
import com.youthtech.rhythmify.data.models.Artist

data class AlbumWithArtist(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        associateBy = Junction(AlbumArtistCrossRef::class)
    )
    val artists: List<Artist>
)