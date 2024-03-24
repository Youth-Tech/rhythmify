package com.youthtech.rhythmify.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.youthtech.rhythmify.data.apis.CookieService
import com.youthtech.rhythmify.data.apis.YoutubeService
import com.youthtech.rhythmify.data.apis.ZingService
import com.youthtech.rhythmify.data.music_service.MusicServiceInterceptor
import com.youthtech.rhythmify.extensions.dataStore
import com.youthtech.rhythmify.utils.BASE_URL
import com.youthtech.rhythmify.utils.YOUTUBE_API_BASE_URL
import com.youthtech.rhythmify.utils.ZING_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @DefaultRetrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cookieService: CookieService): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(MusicServiceInterceptor(cookieService))
            .build()
    }

    @ZingRetrofit
    @Singleton
    @Provides
    fun provideZingRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(ZING_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @CookiesRetrofit
    @Provides
    @Singleton
    fun provideCookiesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(ZING_BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCookiesService(@CookiesRetrofit retrofit: Retrofit): CookieService {
        return retrofit.create(CookieService::class.java)
    }

    @Singleton
    @Provides
    fun provideZingService(@ZingRetrofit retrofit: Retrofit): ZingService {
        return retrofit.create(ZingService::class.java)
    }

    @Singleton
    @Provides
    fun provideYoutubeService(@CookiesRetrofit retrofit: Retrofit): YoutubeService {
        return retrofit.newBuilder()
            .baseUrl(YOUTUBE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YoutubeService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatastore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.dataStore
}