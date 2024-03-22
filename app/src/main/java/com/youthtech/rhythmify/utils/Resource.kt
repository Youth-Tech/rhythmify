package com.youthtech.rhythmify.utils

sealed class Resource<ResultType>(
    val data: ResultType? = null,
    val err: Throwable? = null
) {
    class Success<ResultType>(data: ResultType) : Resource<ResultType>(data)
    class Loading<ResultType>(data: ResultType? = null) : Resource<ResultType>(data)
    class Error<ResultType>(err: Throwable, data: ResultType? = null) :
        Resource<ResultType>(data, err)
}
