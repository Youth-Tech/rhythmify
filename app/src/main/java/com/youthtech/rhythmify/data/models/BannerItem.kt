package com.youthtech.rhythmify.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banner_item")
data class BannerItem (
  @PrimaryKey val encodeId: String,
    val ispr: Int,
    val title: String,
    val description: String,
    val link : String,
    val cover: String,
    val banner :String,
    val type: Int,
    val target: String,
)