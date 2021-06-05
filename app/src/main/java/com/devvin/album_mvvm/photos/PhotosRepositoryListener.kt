package com.devvin.album_mvvm.photos

import com.devvin.album_mvvm.model.Photo

interface PhotosRepositoryListener {
    fun onSuccess( photosList : List<Photo>)
}