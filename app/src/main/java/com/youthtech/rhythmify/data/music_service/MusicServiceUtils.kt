package com.youthtech.rhythmify.data.music_service

import com.youthtech.rhythmify.utils.Commons
import com.youthtech.rhythmify.utils.ZING_SECRET_KEY
import com.youthtech.rhythmify.utils.ZING_VERSION
import com.youthtech.rhythmify.utils.hash256
import com.youthtech.rhythmify.utils.hashHmac512

fun hashHasIdSignature(apiPath: String, id: String): String {
    return hashHmac512(
        "${apiPath}${hash256("ctime=${Commons.currentTime}id=${id}version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}

fun hashNoIdSignature(apiPath: String): String {
    return hashHmac512(
        "${apiPath}${hash256("ctime=${Commons.currentTime}version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}

fun hashHomeRadioSignature(apiPath: String, count: Number): String {
    return hashHmac512(
        "${apiPath}${hash256("count=${count}ctime=${Commons.currentTime}page=1version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}

fun hashListGenreSignature(
    apiPath: String,
    id: String,
    page: Number,
    count: Number? = 10
): String {
    return hashHmac512(
        "${apiPath}${hash256("count=${count}ctime=${Commons.currentTime}id=${id}page=${page}version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}

fun hashListMvSignature(
    apiPath: String,
    id: String,
    type: String,
    page: Number,
    count: Number
): String {
    return hashHmac512(
        "${apiPath}${hash256("count=${count}ctime=${Commons.currentTime}id=${id}page=${page}type=${type}version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}

fun hashCategoryMvSignature(
    apiPath: String,
    id: String,
    type: String,
): String {
    return hashHmac512(
        "${apiPath}${hash256("ctime=${Commons.currentTime}id=${id}type=${type}version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}

fun hashSearchSignature(
    apiPath: String,
    type: String,
    page: Number? = 1,
    count: Number? = 18
): String {
    return hashHmac512(
        "${apiPath}${hash256("count=${count}ctime=${Commons.currentTime}page=${page}type=${type}version=${ZING_VERSION}")}",
        ZING_SECRET_KEY
    )
}
