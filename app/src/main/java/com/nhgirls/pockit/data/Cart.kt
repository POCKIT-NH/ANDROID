package com.nhgirls.pockit.data

import androidx.databinding.BindingConversion
import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("idx")
    val id: Int,
    @SerializedName("product_name")
    val image: String,
    @SerializedName("title")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("count")
    val count: Int,
    var checked: Boolean = false
)