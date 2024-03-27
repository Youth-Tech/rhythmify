package com.youthtech.rhythmify.ui.activities

import android.util.Log
import androidx.lifecycle.coroutineScope
import com.youthtech.rhythmify.data.database.RhythmifyDatabase
import com.youthtech.rhythmify.databinding.ActivityMainBinding
import com.youthtech.rhythmify.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    @Inject
    lateinit var localDb: RhythmifyDatabase

    override fun init() {
    }

    override fun addListener() {
        binding.dbtest.setOnClickListener {
            lifecycle.coroutineScope.launch {
                localDb.songInfoDao().getSongById("222").collect {
                    Log.d(TAG, "addListener: $it")
                }
            }
        }
    }
}