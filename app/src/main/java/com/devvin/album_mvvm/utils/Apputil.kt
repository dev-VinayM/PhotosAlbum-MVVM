package com.devvin.album_mvvm.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.devvin.album_mvvm.R

fun getProgressDrawable(context: Context): CircularProgressDrawable{
return CircularProgressDrawable(context).apply {
    strokeWidth = 10f
    centerRadius = 50f
    start()
}
}

fun ImageView.loadImage( url : String? , progressDrawable: CircularProgressDrawable){
    @GlideModule
    class MyAppGlideModule : AppGlideModule()
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    //issue with the placeholder URL, that`s why adding this code
    val glideUrl = GlideUrl(
        url, LazyHeaders.Builder()
            .addHeader("User-Agent", "your-user-agent")
            .build()
    )

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(glideUrl)
        .into(this)
}

@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView,url: String?){
    view.loadImage(url, getProgressDrawable(view.context))
}

