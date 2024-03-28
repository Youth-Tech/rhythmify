package com.youthtech.rhythmify.ui.activities

import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.youthtech.rhythmify.data.database.RhythmifyDatabase
import com.youthtech.rhythmify.databinding.ActivityMainBinding
import com.youthtech.rhythmify.ui.base.BaseActivity
import com.youthtech.rhythmify.utils.Resource
import com.youthtech.rhythmify.viewmodels.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val testViewModel: TestViewModel by viewModels()

    override fun init() {
    }

    override fun addListener() {
        binding.dbtest.setOnClickListener {
            testViewModel.getSongInfo("ZU0C7BOE")
        }

        lifecycleScope.launch(Dispatchers.IO) {
            testViewModel.songInfo.collect {
                withContext(Dispatchers.Main) {
                    when (it) {
                        is Resource.Error -> Toast.makeText(
                            this@MainActivity,
                            "Error",
                            Toast.LENGTH_LONG
                        ).show()

                        is Resource.Loading -> Toast.makeText(
                            this@MainActivity,
                            "Loading",
                            Toast.LENGTH_LONG
                        ).show()

                        is Resource.Success -> Toast.makeText(
                            this@MainActivity,
                            "Success",
                            Toast.LENGTH_LONG
                        ).show()

                        else -> {
                            Toast.makeText(
                                this@MainActivity,
                                "BlaBla",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }
}