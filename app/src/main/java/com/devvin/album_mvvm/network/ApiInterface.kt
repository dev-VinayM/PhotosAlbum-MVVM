package com.devvin.album_mvvm.network

import com.devvin.album_mvvm.model.Album
import com.devvin.album_mvvm.model.Photo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("albums")
    fun getAlbumsAsync(): Deferred<Response<List<Album>>>

    @GET("photos")
    fun getPhotosAsync(): Deferred<Response<List<Photo>>>
}