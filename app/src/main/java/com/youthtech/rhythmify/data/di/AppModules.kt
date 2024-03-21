package com.youthtech.rhythmify.data.di

import com.youthtech.rhythmify.data.apis.CookieService
import com.youthtech.rhythmify.data.apis.ZingService
import com.youthtech.rhythmify.data.music_service.MusicServiceInterceptor
import com.youthtech.rhythmify.utils.Configs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ZingRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CookiesRetrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @DefaultRetrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Configs.BASE_URL)
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
        return Retrofit.Builder().baseUrl(Configs.ZING_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @CookiesRetrofit
    @Provides
    @Singleton
    fun provideCookiesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Configs.ZING_BASE_URL)
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
}