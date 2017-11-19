package com.sys1yagi.android.prpl.data.source.exception

import retrofit2.Response

class ErrorResponseException(val response: Response<out Any>) : Exception() {
}
