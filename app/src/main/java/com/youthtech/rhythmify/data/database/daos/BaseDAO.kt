package com.youthtech.rhythmify.data.database.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.OnConflictStrategy

interface BaseDAO<Type> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg t: Type)

    @Update
    suspend fun update(t: Type)

    @Delete
    suspend fun delete(t: Type)

}