package com.youthtech.rhythmify.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Album (
 @PrimaryKey val encodeId: String,
    val title: String,
    val thumbnail: String,
//    val isoffical: Boolean,
    val link: String,
//    val isIndie: Boolean,
    val releaseDate: String,
    val sortDescription: String,
    val releasedAt: Long,
    val genreIds: List<String>,
//    @SerializedName("PR")
//    val pr: Boolean,
    val artists: List<Artist>,
    val artistsNames: String,
)