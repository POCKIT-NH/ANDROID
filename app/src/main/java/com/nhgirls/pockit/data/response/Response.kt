package com.nhgirls.pockit.data.response

data class Response<T> (
    val success: Boolean,
    val message: String,
    val data: T
)
