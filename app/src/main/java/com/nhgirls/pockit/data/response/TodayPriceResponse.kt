package com.nhgirls.pockit.data.response

data class TodayPriceResponse(
    val idx : Int,
    val title: String,
    val product_img: String,
    val category: Int? = 0,
    val price: Int
)