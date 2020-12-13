package com.nhgirls.pockit.api

import com.nhgirls.pockit.data.Cart
import com.nhgirls.pockit.data.response.Response
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {
    @GET("/cart")
    fun getCarts(): Call<Response<List<Cart>>>
}