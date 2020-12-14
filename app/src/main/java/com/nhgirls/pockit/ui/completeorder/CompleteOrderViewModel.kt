package com.nhgirls.pockit.ui.completeorder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompleteOrderViewModel: ViewModel() {
    private val _totalPrice = MutableLiveData<Int>()
    val totalPrice: LiveData<Int>
    get() = _totalPrice

    fun setTotalPrice(totalPrice: Int) {
        _totalPrice.value = totalPrice
    }
}