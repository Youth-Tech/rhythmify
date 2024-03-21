package com.youthtech.rhythmify.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.youthtech.rhythmify.data.apis.ZingService
import com.youthtech.rhythmify.data.music_service.ApiPath
import com.youthtech.rhythmify.data.music_service.MusicServiceUtils
import com.youthtech.rhythmify.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    @Inject
    lateinit var zingService: ZingService

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.api.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val homeRes = zingService.getSong(
                    id = "Z7Z6O988",
                    sig = MusicServiceUtils.hashHasIdSignature(ApiPath.GET_SONG, "Z7Z6O988")
                )
            }
        }
    }
}