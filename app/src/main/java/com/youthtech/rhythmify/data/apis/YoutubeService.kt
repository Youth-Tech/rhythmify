package com.youthtech.rhythmify.data.apis

import com.youthtech.rhythmify.data.dto.YoutubeSearchResponse
import com.youthtech.rhythmify.data.music_service.ApiPath
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