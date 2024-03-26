package com.youthtech.rhythmify.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Composer (
   @PrimaryKey val id: String,
    val name: String,
    val alias: String,
    val playlistId: String,
    val cover: String,
    val thumbnail: String,
    val totalFollow: Long,
)