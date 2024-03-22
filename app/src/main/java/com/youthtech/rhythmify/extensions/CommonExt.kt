package com.youthtech.rhythmify.extensions

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.youthtech.rhythmify.utils.SETTING_FOLDER


val Context.dataStore by preferencesDataStore(name = SETTING_FOLDER)