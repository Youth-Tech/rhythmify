package com.youthtech.rhythmify.data.music_service

import android.util.Log
import com.youthtech.rhythmify.data.apis.CookieService
import com.youthtech.rhythmify.utils.Commons
import com.youthtech.rhythmify.utils.Configs
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

        val cookies = runBlocking {
            val cookieRes = cookieService.getCookie()
            cookieRes.headers()
        }
        val headerMapList: Map<String, List<String>> = cookies.toMultimap()
        val allCookies: List<String>? = headerMapList["set-cookie"]
        var requestCookie: String = ""

        allCookies?.let {
            if (allCookies.isNotEmpty() && allCookies.size >= 2) {
                requestCookie = allCookies[1]
                Log.d("MusicServiceInterceptor", "cookies: ${allCookies[1]}")
            }
        }

        //handle new header with cookies
        val newHeader: Headers = Headers.Builder()
            .add("Cookie", requestCookie)
            .build()

        //handle default query string
        Log.d("MusicServiceInterceptor", "intercept: ${Commons.currentTime}")
        val newUrl: HttpUrl =
            chain.request().url.newBuilder()
                .addQueryParameter("ctime", Commons.currentTime)
                .addQueryParameter("version", Configs.ZING_VERSION)
                .addQueryParameter("apiKey", Configs.ZING_API_KEY)
                .build()

        val newRequest = originRequest.newBuilder().url(newUrl).headers(newHeader).build()

        return chain.proceed(newRequest)
    }
}