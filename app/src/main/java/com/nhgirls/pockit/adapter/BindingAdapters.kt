package com.nhgirls.pockit.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.nhgirls.pockit.common.GlideApp

@BindingAdapter("glideImageRes")
fun setGlideImageRes(imageView: ImageView, image: Int) {
    GlideApp.with(imageView)
        .load(image)
        .into(imageView)
}

@BindingAdapter("glideImageString")
fun setGlideImageString(imageView: ImageView, image: String) {
    GlideApp.with(imageView)
        .load(image)
        .into(imageView)
}

