package com.devvin.album_mvvm.albums

import com.devvin.album_mvvm.network.RetrofitInstance.apiInterface
import com.devvin.album_mvvm.network.safeApiCall

class AlbumsRepository(private val albumsRepositoryListener: AlbumRepositoryListener) {


    suspend fun getAlbumList() {
        val response = safeApiCall(
            call = { apiInterface.getAlbumsAsync().await() },
            errorMessage = "Error Fetching Album List"
        )

        response?.let {
            albumsRepositoryListener.onSuccess(response)
        }
    }
}