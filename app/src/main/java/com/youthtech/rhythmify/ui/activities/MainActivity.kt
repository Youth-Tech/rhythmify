package com.youthtech.rhythmify.ui.activities

import com.youthtech.rhythmify.data.apis.YoutubeService
import com.youthtech.rhythmify.data.apis.ZingService
import com.youthtech.rhythmify.data.music_service.ApiPath
import com.youthtech.rhythmify.data.music_service.hashHasCountSignature
import com.youthtech.rhythmify.data.music_service.hashHomeRadioSignature
import com.youthtech.rhythmify.data.music_service.hashNoIdSignature
import com.youthtech.rhythmify.databinding.ActivityMainBinding
import com.youthtech.rhythmify.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    @Inject
    lateinit var zingService: ZingService

    @Inject
    lateinit var youtubeService: YoutubeService

    override fun init() {
    }

    override fun addListener() {
        binding.api.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                zingService.getTop100(
                    sig = hashNoIdSignature(
                        ApiPath.GET_TOP_100,
                    )
                )
            }
        }

        binding.api2.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                zingService.getHome(
                    sig = hashHomeRadioSignature(
                        ApiPath.GET_HOME,
                        15
                    )
                )
            }
        }

        binding.api3.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                youtubeService.getSearchResultFromYoutube("Thích em hơi nhiều - WrenEven")
            }
        }
    }
}