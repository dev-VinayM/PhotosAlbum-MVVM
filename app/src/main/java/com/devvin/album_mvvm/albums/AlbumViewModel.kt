package com.devvin.album_mvvm.albums

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devvin.album_mvvm.model.Album
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel(), AlbumRepositoryListener {
    private val repository: AlbumsRepository = AlbumsRepository(this)
    val albumListData = MutableLiveData<List<Album>>()

    fun getAlbumList() {
        viewModelScope.launch {
            repository.getAlbumList()
        }
    }

    override fun onSuccess(albumList: List<Album>) {
        albumListData.value = albumList
    }
}