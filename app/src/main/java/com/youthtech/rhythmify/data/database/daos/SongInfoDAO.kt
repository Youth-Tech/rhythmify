//package com.youthtech.rhythmify.data.database.daos
//
//import androidx.room.Dao
//import androidx.room.Query
//import androidx.room.Transaction
//import androidx.lifecycle.LiveData
//import com.youthtech.rhythmify.models.songinfo.SongInfo
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface SongInfoDAO : BaseDAO<SongInfo> {
//    @Transaction
//    @Query("select * from Song where encodeId =:id")
//    fun getSongById(id: String) : Flow<SongInfo>
//}
//
