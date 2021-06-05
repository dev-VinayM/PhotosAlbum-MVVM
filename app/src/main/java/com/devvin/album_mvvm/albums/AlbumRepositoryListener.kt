package com.devvin.album_mvvm.albums

import com.devvin.album_mvvm.model.Album

interface AlbumRepositoryListener {
    fun onSuccess(albumList : List<Album>)
}