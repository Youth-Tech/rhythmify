package com.youthtech.rhythmify.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youthtech.rhythmify.data.network.dto.ZingGetHubHomeResponse
import com.youthtech.rhythmify.data.repositories.TopicCategoryRepository
import com.youthtech.rhythmify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicCategoryViewModel @Inject constructor(private val topicCategoryRepository: TopicCategoryRepository) :
    ViewModel() {
    private val _hubHome: MutableStateFlow<Resource<ZingGetHubHomeResponse>> =
        MutableStateFlow(Resource.Loading())
    val hubHome = _hubHome.asStateFlow()

    init {
        getHubHome()
    }

    private fun getHubHome() {
        viewModelScope.launch(Dispatchers.IO) {
            topicCategoryRepository.getHubHome().collect {
                _hubHome.value = it
            }
        }
    }
}