package com.nhgirls.pockit.api

import com.nhgirls.pockit.data.requesst.LoginRequest
import com.nhgirls.pockit.data.response.CartResponse
import com.nhgirls.pockit.data.response.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {
    @GET("/cart")
    fun getCarts(): Call<Response<CartResponse>>

    @POST("/user/login")
    fun postLogin(@Body loginRequest: LoginRequest) : Call<Response<Unit>>

}