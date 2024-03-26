package com.youthtech.rhythmify.models

import androidx.room.Entity

@Entity
data class Composer (
    val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val playlistId: String,
    val cover: String,
    val thumbnail: String,
    val totalFollow: Long,
)