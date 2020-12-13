package com.nhgirls.pockit.data.response

import com.google.gson.annotations.SerializedName
import com.nhgirls.pockit.data.Cart

data class CartResponse (
    @SerializedName("user_idx")
    val userId: Int,
    @SerializedName("order_idx")
    val orderId: Int,
    @SerializedName("delivery_date")
    val deliveryDate: String,
    @SerializedName("delivery_price")
    val deliveryCharge: Int,
    @SerializedName("product")
    val products: List<Cart>
)
