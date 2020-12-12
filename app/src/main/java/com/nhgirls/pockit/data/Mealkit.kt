package com.nhgirls.pockit.data

import androidx.annotation.DrawableRes

data class Mealkit(
    @DrawableRes val image: Int,
    val name: String,
    val price: Int,
    val ifLike: Boolean,
    val like: Int
)