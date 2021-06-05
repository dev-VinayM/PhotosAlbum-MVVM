package com.devvin.album_mvvm.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devvin.album_mvvm.R
import com.devvin.album_mvvm.databinding.ViewAlbumListItemBinding
import com.devvin.album_mvvm.databinding.ViewPhotoListItemBinding
import com.devvin.album_mvvm.model.Photo

class PhotosListAdapter(private val data: List<Photo>) :
    RecyclerView.Adapter<PhotosListAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.photo = data[position]
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewPhotoListItemBinding>(
            inflater,
            R.layout.view_photo_list_item,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    class MyViewHolder(val view: ViewPhotoListItemBinding) : RecyclerView.ViewHolder(view.root)
}