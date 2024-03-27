package com.youthtech.rhythmify.data.models.songinfo

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.youthtech.rhythmify.data.models.Album
import com.youthtech.rhythmify.data.models.Artist
import com.youthtech.rhythmify.data.models.Composer
import com.youthtech.rhythmify.data.models.Genre
import com.youthtech.rhythmify.data.models.Song

data class SongInfo(
    @Embedded val song: Song,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        entity = Genre::class,
        associateBy = Junction(
            value = SongGenreCrossRef::class,
            parentColumn = "songId",
            entityColumn = "genreId"
        )
    )
    val genres: List<Genre>,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        entity = Composer::class,
        associateBy = Junction(
            value = SongComposerCrossRef::class,
            parentColumn = "songId",
            entityColumn = "composerId"
        )
    )
    val composers: List<Composer>,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        entity = Artist::class,
        associateBy = Junction(
            value = SongArtistCrossRef::class,
            parentColumn = "songId",
            entityColumn = "artistId"
        )
    )
    val artists: List<Artist>,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        entity = Album::class
    )
    val album: Album
)