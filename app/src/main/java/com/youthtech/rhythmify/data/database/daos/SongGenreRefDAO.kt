package com.youthtech.rhythmify.data.database.daos

import androidx.room.Dao
import com.youthtech.rhythmify.data.models.songinfo.SongGenreCrossRef

@Dao
interface SongGenreRefDAO : BaseDAO<SongGenreCrossRef>