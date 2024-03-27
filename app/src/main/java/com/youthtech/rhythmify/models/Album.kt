package com.youthtech.rhythmify.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album")
data class Album(
    @PrimaryKey val id: String,
    val title: String,
    val thumbnail: String,
    val link: String,
    val releaseDate: String,
    val sortDescription: String,
    val releasedAt: Long,
    val artistsNames: String,
)