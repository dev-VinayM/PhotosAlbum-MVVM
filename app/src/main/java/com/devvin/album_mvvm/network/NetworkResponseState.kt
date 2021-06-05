package com.devvin.album_mvvm.network

sealed class NetworkResponseState<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponseState<T>()
    data class Error(val exception: Exception) : NetworkResponseState<Nothing>()
}