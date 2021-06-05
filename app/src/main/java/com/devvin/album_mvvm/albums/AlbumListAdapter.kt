package com.devvin.album_mvvm.albums

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devvin.album_mvvm.R
import com.devvin.album_mvvm.databinding.ViewAlbumListItemBinding
import com.devvin.album_mvvm.model.Album
import com.devvin.album_mvvm.photos.PhotosActivity

class AlbumListAdapter(private val data: List<Album>, private val context : Context) :
    RecyclerView.Adapter<AlbumListAdapter.MyViewHolder>(), AlbumItemClickListener{

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.album = data[position]
        holder.view.listener = this
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewAlbumListItemBinding>(
            inflater,
            R.layout.view_album_list_item,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    class MyViewHolder(val view: ViewAlbumListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onItemClicked(view: View) {
        val albumId = view.findViewById<TextView>(R.id.tv_albumId).text.toString().toInt()
        val intent = Intent(context, PhotosActivity::class.java)
        intent.putExtra("albumId", albumId)
        context.startActivity(intent)
    }
}