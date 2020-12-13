package com.nhgirls.pockit.data.response

data class TodayPriceResponse(
    val imageUrl: String,
    val title: String,
    val price: Int,
    val like: Int
)