package com.youthtech.rhythmify.data.music_service

import com.youthtech.rhythmify.data.apis.CookieService
import com.youthtech.rhythmify.utils.Commons
import com.youthtech.rhythmify.utils.ZING_API_KEY
import com.youthtech.rhythmify.utils.ZING_KEYWORD_HOST
import com.youthtech.rhythmify.utils.ZING_KEYWORD_SCHEMA
import com.youthtech.rhythmify.utils.ZING_VERSION
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class MusicServiceInterceptor @Inject constructor(private val cookieService: CookieService) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originRequest = chain.request()

        val requestCookie = Commons.zingCookies.ifEmpty {
            val cookies = runBlocking {
                val cookieRes = cookieService.getCookie()
                cookieRes.headers()
            }

            val headerMapList: Map<String, List<String>> = cookies.toMultimap()
            val allCookies: List<String>? = headerMapList["set-cookie"]

            allCookies?.let {
                if (allCookies.isNotEmpty() && allCookies.size >= 2) {
                    Commons.zingCookies = allCookies[1]
//                Log.d("MusicServiceInterceptor", "cookies: ${allCookies[1]}")
                }
            }
            Commons.zingCookies
        }


//        handle new header with cookies
        val newHeader: Headers = Headers.Builder()
            .add("Cookie", requestCookie)
            .build()

        //handle default query string
//        Log.d("MusicServiceInterceptor", "intercept: ${Commons.currentTime}")
        val newUrlBuilder: HttpUrl.Builder =
            originRequest.url.newBuilder()
                .addQueryParameter("ctime", Commons.currentTime)
                .addQueryParameter("version", ZING_VERSION)
                .addQueryParameter("apiKey", ZING_API_KEY)

        //handle suggest keyword url
        val isSuggestKeywordUrl = newUrlBuilder.toString().contains(ApiPath.GET_SUGGEST_KEYWORD)
//        Log.d("MusicServiceInterceptor", "intercept: $newUrlBuilder")
        if (isSuggestKeywordUrl) {
            newUrlBuilder
                .scheme(ZING_KEYWORD_SCHEMA)
                .host(ZING_KEYWORD_HOST)
        }

        val newRequest =
            originRequest.newBuilder()
                .url(newUrlBuilder.build())
                .headers(newHeader)
                .build()

        return chain.proceed(newRequest)
    }
}