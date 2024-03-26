package com.youthtech.rhythmify.models.songinfo

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.youthtech.rhythmify.models.Album
import com.youthtech.rhythmify.models.Artist
import com.youthtech.rhythmify.models.Composer
import com.youthtech.rhythmify.models.Genre
import com.youthtech.rhythmify.models.Song

data class SongInfo(
    @Embedded val song: Song,
    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        associateBy = Junction(SongGenreCrossRef::class)
    )
    val genres: List<Genre>,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        associateBy = Junction(SongComposerCrossRef::class)
    )
    val composers: List<Composer>,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id",
        associateBy = Junction(SongArtistCrossRef::class)
    )
    val artists: List<Artist>,

    @Relation(
        parentColumn = "encodeId",
        entityColumn = "id"
    )
    val album: Album
)