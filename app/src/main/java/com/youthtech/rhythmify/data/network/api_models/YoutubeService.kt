package com.youthtech.rhythmify.data.network.api_models

import com.youthtech.rhythmify.data.network.dto.YoutubeSearchResponse
import com.youthtech.rhythmify.data.network.utils.ApiPath
import com.youthtech.rhythmify.utils.YOUTUBE_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeService {
    @GET(ApiPath.YOUTUBE_SEARCH)
    suspend fun getSearchResultFromYoutube(
        @Query("q") musicName: String,
        @Query("key") apiKey: String? = YOUTUBE_API_KEY,
        @Query("type") type: String? = "video",
        @Query("videoCategoryId") videoCategoryId: String? = "20"
    ): Response<YoutubeSearchResponse>
}