package com.youthtech.rhythmify.data.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.youthtech.rhythmify.models.Song
import com.youthtech.rhythmify.models.songinfo.SongInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDAO : BaseDAO<Song> {
    @Transaction
    @Query("select * from song where encodeId =:id")
    fun getSongById(id: String): Flow<SongInfo>
}

