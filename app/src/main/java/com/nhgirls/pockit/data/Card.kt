package com.nhgirls.pockit.data

data class Card(
    val id: Int,
    val company: String,
    val number: String,
    val isChecked: Boolean = false
)