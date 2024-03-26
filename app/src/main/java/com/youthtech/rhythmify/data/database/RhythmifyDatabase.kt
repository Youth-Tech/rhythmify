package com.youthtech.rhythmify.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.youthtech.rhythmify.data.database.daos.SongInfoDAO
import com.youthtech.rhythmify.models.songinfo.SongInfo

@Database(entities = [SongInfo::class], version = 1)
abstract class RhythmifyDatabase : RoomDatabase() {
    abstract fun getSongInfoDAO(): SongInfoDAO


}