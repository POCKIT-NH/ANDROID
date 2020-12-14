package com.nhgirls.pockit.data.requesst

import com.google.gson.annotations.SerializedName

data class NhPayRequest(
    @SerializedName("price")
    val price: String,
    @SerializedName("product")
    val product: String,
    @SerializedName("userFinAc")
    val userFinAc: String = "00820100007500000000000005769",
    @SerializedName("sellerAc")
    val sellerAc: String = "3020000003415"
)