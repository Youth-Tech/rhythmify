package com.youthtech.rhythmify.data.database.daos

import androidx.room.Dao
import com.youthtech.rhythmify.data.models.songinfo.SongArtistCrossRef

@Dao
interface SongArtistRefDAO : BaseDAO<SongArtistCrossRef>