package com.nhgirls.pockit.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.nhgirls.pockit.common.GlideApp

@BindingAdapter("glideImage")
fun setGlideImage(imageView: ImageView, image: Int) {
    GlideApp.with(imageView)
        .load(image)
        .into(imageView)
}