package com.devvin.album_mvvm.network

import retrofit2.Response
import java.io.IOException

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {
    val result: NetworkResponseState<T> = safeApiResult(call, errorMessage)
    var data: T? = null

    when (result) {
        is NetworkResponseState.Success ->
            data = result.data
        is NetworkResponseState.Error -> {
            //do something in case of error
        }
    }
    return data
}


private suspend fun <T : Any> safeApiResult(
    call: suspend () -> Response<T>,
    errorMessage: String
): NetworkResponseState<T> {
    val response = call.invoke()
    if (response.isSuccessful) return NetworkResponseState.Success(response.body()!!)

    return NetworkResponseState.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
}