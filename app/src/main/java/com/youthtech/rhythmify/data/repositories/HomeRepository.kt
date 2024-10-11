package com.youthtech.rhythmify.data.repositories

import com.youthtech.rhythmify.utils.Resource
import com.youthtech.rhythmify.data.network.api_models.ZingService
import com.youthtech.rhythmify.data.network.dto.ZingHomeResponse
import com.youthtech.rhythmify.data.network.utils.ApiPath
import com.youthtech.rhythmify.data.network.utils.hashHomeRadioSignature
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val zingService: ZingService) {
    fun getHome() = flow<Resource<ZingHomeResponse>> {
        emit(Resource.Loading())
        try {
            val res = zingService.getHome(sig = hashHomeRadioSignature(ApiPath.GET_HOME,15))
            val body = res.body()?.let { body ->
                Resource.Success(body)
            } ?: run {
                Resource.Error(Throwable("Empty data"))
            }
            emit(body)
        }catch (e: Throwable){
            emit(Resource.Error(e))
        }
    }
}