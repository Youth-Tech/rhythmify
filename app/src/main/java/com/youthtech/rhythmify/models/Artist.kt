package com.youthtech.rhythmify.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist")
data class Artist (
  @PrimaryKey val id: String,
    val name: String,
    val alias: String,
    val thumbnail: String,
    val thumbnailM: String?,
    val playlistId: String?,
    val totalFollow: Long?,
)