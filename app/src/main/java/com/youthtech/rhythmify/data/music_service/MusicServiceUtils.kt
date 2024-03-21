package com.youthtech.rhythmify.data.music_service

import com.youthtech.rhythmify.utils.Commons
import com.youthtech.rhythmify.utils.Configs
import com.youthtech.rhythmify.utils.Crypto

object MusicServiceUtils {
    fun hashHasIdSignature(apiPath: String, id: String): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("ctime=${Commons.currentTime}id=${id}version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }

    fun hashNoIdSignature(apiPath: String): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("ctime=${Commons.currentTime}version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }

    fun hashHomeRadioSignature(apiPath: String, count: Number): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("count=${count}ctime=${Commons.currentTime}page=1version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }

    fun hashListGenreSignature(
        apiPath: String,
        id: String,
        page: Number,
        count: Number? = 10
    ): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("count=${count}ctime=${Commons.currentTime}id=${id}page=${page}version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }

    fun hashListMvSignature(
        apiPath: String,
        id: String,
        type: String,
        page: Number,
        count: Number
    ): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("count=${count}ctime=${Commons.currentTime}id=${id}page=${page}type=${type}version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }

    fun hashCategoryMvSignature(
        apiPath: String,
        id: String,
        type: String,
    ): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("ctime=${Commons.currentTime}id=${id}type=${type}version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }

    fun hashSearchSignature(
        apiPath: String,
        type: String,
        page: Number,
        count: Number
    ): String {
        return Crypto.hashHmac512(
            "${apiPath}${Crypto.hash256("count=${count}ctime=${Commons.currentTime}page=${page}type=${type}version=${Configs.ZING_VERSION}")}",
            Configs.ZING_SECRET_KEY
        )
    }
}