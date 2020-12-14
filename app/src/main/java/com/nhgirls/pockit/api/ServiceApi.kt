package com.nhgirls.pockit.api

import com.nhgirls.pockit.data.requesst.LoginRequest
import com.nhgirls.pockit.data.response.CartResponse
import com.nhgirls.pockit.data.response.Response
import com.nhgirls.pockit.data.response.TodayPockitResponse
import com.nhgirls.pockit.data.response.TodayPriceResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {
    @GET("/cart")
    fun getCarts(): Call<Response<CartResponse>>

    @GET("/forest")
    fun getForest(): Call<Response<Int>>

    /**
     * 로그인
     */
    @POST("/user/login")
    fun postLogin(@Body loginRequest: LoginRequest) : Call<Response<Unit>>

    /**
     * 오늘의 특가
     */
    @GET("/home/today")
    fun getTodayPrice() : Call<Response<List<TodayPriceResponse>>>
}