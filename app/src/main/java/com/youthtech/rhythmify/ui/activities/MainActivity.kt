package com.youthtech.rhythmify.ui.activities

import com.youthtech.rhythmify.data.apis.ZingService
import com.youthtech.rhythmify.data.music_service.ApiPath
import com.youthtech.rhythmify.data.music_service.hashHomeRadioSignature
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

    override fun init() {
    }

    override fun addListener() {
        binding.api.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                zingService.getRadio(
                    sig = hashHomeRadioSignature(
                        ApiPath.GET_RADIO
                    )
                )
            }
        }
    }
}