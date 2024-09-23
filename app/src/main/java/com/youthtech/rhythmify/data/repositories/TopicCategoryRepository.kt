package com.youthtech.rhythmify.data.repositories

import com.youthtech.rhythmify.data.network.api_models.ZingService
import com.youthtech.rhythmify.data.network.dto.ZingGetHubHomeResponse
import com.youthtech.rhythmify.data.network.utils.ApiPath
import com.youthtech.rhythmify.data.network.utils.hashNoIdSignature
import com.youthtech.rhythmify.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopicCategoryRepository @Inject constructor(private val zingService: ZingService) {
    fun getHubHome() = flow<Resource<ZingGetHubHomeResponse>> {
        emit(Resource.Loading())
        try {
            val res = zingService.getHubHome(hashNoIdSignature(ApiPath.GET_HUB_HOME))
            val body = res.body()?.let { body ->
                Resource.Success(body)
            } ?: run {
                Resource.Error(Throwable("Empty data"))
            }
            emit(body)
        } catch (e: Throwable) {
            emit(Resource.Error(e))
        }
    }
}