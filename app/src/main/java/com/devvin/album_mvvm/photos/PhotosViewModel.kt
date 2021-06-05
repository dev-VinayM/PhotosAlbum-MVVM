package com.devvin.album_mvvm.photos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devvin.album_mvvm.model.Photo
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel(), PhotosRepositoryListener {
    private val repository: PhotosRepository = PhotosRepository(this)
    val photoListData = MutableLiveData<List<Photo>>()

    fun getPhotos(albumId : Int) {
        viewModelScope.launch {
            repository.getPhotoList(albumId)
        }
    }

    override fun onSuccess(photosList: List<Photo>) {
        photoListData.value = photosList
    }
}