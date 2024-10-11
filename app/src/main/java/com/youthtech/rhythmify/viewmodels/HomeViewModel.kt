package com.youthtech.rhythmify.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youthtech.rhythmify.data.network.dto.ZingHomeResponse
import com.youthtech.rhythmify.data.repositories.HomeRepository
import com.youthtech.rhythmify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository): ViewModel() {

    private val _home: MutableStateFlow<Resource<ZingHomeResponse>> =
        MutableStateFlow(Resource.Loading())
    val home = _home.asStateFlow()


    init {
        getHome()
    }
    private fun getHome(){
        viewModelScope.launch(Dispatchers.IO) {
            homeRepository.getHome().collect {
                _home.value = it
            }
        }
    }
}