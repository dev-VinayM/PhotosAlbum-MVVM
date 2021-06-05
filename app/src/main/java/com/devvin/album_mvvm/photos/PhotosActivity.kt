package com.devvin.album_mvvm.photos

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devvin.album_mvvm.R

class PhotosActivity : AppCompatActivity() {
    private val photosViewModel by viewModels<PhotosViewModel>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PhotosListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        observeDataAndSetRecyclerView()
        photosViewModel.getPhotos()
    }

    private fun observeDataAndSetRecyclerView() {
        photosViewModel.photoListData.observe(this, Observer {
            it?.let {
                viewManager = GridLayoutManager(this, 2)
                viewAdapter = PhotosListAdapter(it)

                recyclerView = findViewById<RecyclerView>(R.id.rv_photoList).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }
        })
    }
}