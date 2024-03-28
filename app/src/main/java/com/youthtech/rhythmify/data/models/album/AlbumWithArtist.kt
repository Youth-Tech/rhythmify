package com.youthtech.rhythmify.data.models.album

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.youthtech.rhythmify.data.models.Album
import com.youthtech.rhythmify.data.models.Artist

data class AlbumWithArtist(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        entity = Artist::class,
        associateBy = Junction(
            value = AlbumArtistCrossRef::class,
            entityColumn = "artistId",
            parentColumn = "albumId"
        )
    )
    val artists: List<Artist>
)