package com.youthtech.rhythmify.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.youthtech.rhythmify.data.network.dto.Artist
import com.youthtech.rhythmify.data.network.dto.Composer
import com.youthtech.rhythmify.data.network.dto.Genre
import com.youthtech.rhythmify.data.network.dto.PreviewInfo

@Entity(tableName = "song")
data class Song(
    @PrimaryKey val encodeId: String,
    val title: String,
    val alias: String,
    val artistsNames: String,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val releaseDate: Long,
    val distributor: String,
    val streamingStatus: Long,
    val hasLyric: Boolean,
    val like: Long,
    val listen: Long,
    val liked: Boolean,
    val comment: Long,
    val albumId: String
)