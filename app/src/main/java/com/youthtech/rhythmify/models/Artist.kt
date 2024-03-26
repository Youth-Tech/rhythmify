package com.youthtech.rhythmify.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Artist (
  @PrimaryKey val id: String,
    val name: String,
    val link: String,
    val spotlight: Boolean,
    val alias: String,
    val thumbnail: String,
    val thumbnailM: String?,
    val isOA: Boolean?,
    val isOABrand: Boolean?,
    val playlistId: String?,
    val totalFollow: Long?,
)