package com.nhgirls.pockit.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service{
    private const val BASE_URL = "http://15.165.86.166:4000"

    private val logInterceptor = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    private val client = OkHttpClient.Builder()
        .addInterceptor(logInterceptor)
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val service: ServiceApi = retrofit.create(ServiceApi::class.java)
}