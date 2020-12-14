package com.nhgirls.pockit.data.response

import com.google.gson.annotations.SerializedName

data class NhPayResponse(
    @SerializedName("Header")
    val header:Header
)