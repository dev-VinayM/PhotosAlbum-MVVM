package com.devvin.album_mvvm.photos

import com.devvin.album_mvvm.network.RetrofitInstance.apiInterface
import com.devvin.album_mvvm.network.safeApiCall

class PhotosRepository(private val photosRepositoryListener: PhotosRepositoryListener) {

    suspend fun getPhotoList(albumId : Int) {
        val response = safeApiCall(
            call = { apiInterface.getPhotosAsync().await() },
            errorMessage = "Error Fetching Photo List"
        )

        response?.let {
            val data = response.filter { it.albumId == albumId }
            photosRepositoryListener.onSuccess(data)
        }
    }
}