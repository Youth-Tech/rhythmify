package com.youthtech.rhythmify.extensions

import android.content.Context
import android.widget.ImageView
import androidx.datastore.preferences.preferencesDataStore
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.youthtech.rhythmify.utils.SETTING_FOLDER


val Context.dataStore by preferencesDataStore(name = SETTING_FOLDER)
fun Context.glide(imageUrl: String, imageView: ImageView) {
    Glide.with(this).load(imageUrl).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView)
}