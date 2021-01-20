package com.itg.itgmarvel.utility

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.itg.itgmarvel.R

fun getProcessDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
    val imgUri = Uri.parse(uri).buildUpon().scheme("https").build()

    val requestOptions = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_baseline_broken_image_24)

    Glide.with(context)
        .setDefaultRequestOptions(requestOptions)
        .load(imgUri)
        .into(this)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgView.loadImage(imgUrl, getProcessDrawable(imgView.context))
}