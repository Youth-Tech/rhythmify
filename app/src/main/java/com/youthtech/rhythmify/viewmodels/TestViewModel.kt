package com.youthtech.rhythmify.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youthtech.rhythmify.data.models.songinfo.SongInfo
import com.youthtech.rhythmify.data.repositories.TestRepository
import com.youthtech.rhythmify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val testRepository: TestRepository) : ViewModel() {
    private val _songInfo: MutableStateFlow<Resource<SongInfo>> =
        MutableStateFlow(Resource.Loading())
    val songInfo: StateFlow<Resource<SongInfo>> = _songInfo

    fun getSongInfo(songId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            testRepository.getSongInfo(songId).collect {
                _songInfo.value = it
            }
        }
    }
}