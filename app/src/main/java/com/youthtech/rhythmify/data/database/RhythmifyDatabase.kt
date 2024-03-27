package com.youthtech.rhythmify.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.youthtech.rhythmify.data.database.daos.SongDAO
import com.youthtech.rhythmify.models.Album
import com.youthtech.rhythmify.models.Artist
import com.youthtech.rhythmify.models.Composer
import com.youthtech.rhythmify.models.Genre
import com.youthtech.rhythmify.models.Song
import com.youthtech.rhythmify.models.album.AlbumArtistCrossRef
import com.youthtech.rhythmify.models.songinfo.SongArtistCrossRef
import com.youthtech.rhythmify.models.songinfo.SongComposerCrossRef
import com.youthtech.rhythmify.models.songinfo.SongGenreCrossRef

@Database(
    entities = [
        Song::class,
        Genre::class,
        Album::class,
        Artist::class,
        Composer::class,
        SongGenreCrossRef::class,
        SongArtistCrossRef::class,
        AlbumArtistCrossRef::class,
        SongComposerCrossRef::class,
    ],
    version = 1
)
abstract class RhythmifyDatabase : RoomDatabase() {
    abstract fun songInfoDao(): SongDAO
}