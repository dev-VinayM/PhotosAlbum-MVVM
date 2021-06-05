package com.devvin.album_mvvm.albums

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devvin.album_mvvm.R

class AlbumsActivity : AppCompatActivity() {
    private val albumViewModel by viewModels<AlbumViewModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: AlbumListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        observeDataAndSetRecyclerView()
        albumViewModel.getAlbumList()
    }

    private fun observeDataAndSetRecyclerView() {
        albumViewModel.albumListData.observe(this, Observer {
            it?.let {
                viewManager = GridLayoutManager(this, 3)
                viewAdapter = AlbumListAdapter(it, this)

                recyclerView = findViewById<RecyclerView>(R.id.rv_albumList).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }
        })
    }
}