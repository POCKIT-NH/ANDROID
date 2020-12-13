package com.nhgirls.pockit.data

import androidx.databinding.BindingConversion

data class Cart(
    val image: String,
    val name: String,
    val price: Int,
    val count: Int,
    var checked: Boolean = false
)