package com.nhgirls.pockit.ui.password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.api.Service
import com.nhgirls.pockit.data.requesst.NhPayRequest
import com.nhgirls.pockit.utils.safeEnqueue

class PasswordViewModel : ViewModel() {
    private val password: MutableList<Int> = MutableList(6) { it }
    private var totalPrice: Int = 0

    private val _goCompleteOrder= MutableLiveData(false)
    val goCompleteOrder: LiveData<Boolean>
    get() = _goCompleteOrder


    fun savePassword(index: Int, password: Int) {
        this.password[index] = password
    }

    fun postNhPay() {
        Service.service.postNhPay(NhPayRequest(totalPrice.toString(), "단호박 크림 파스타 외 2건"))
            .safeEnqueue(
                {},
                {_goCompleteOrder.value = true},
                {})
    }

    fun setTotalPrice(totalPrice: Int) {
        this.totalPrice = totalPrice
    }

    fun getTotalPrice(): Int = totalPrice

    companion object {
        const val FIRST_PASSWORD_INDEX = 0
        const val SECOND_PASSWORD_INDEX = 0
        const val THIRD_PASSWORD_INDEX = 0
        const val FOURTH_PASSWORD_INDEX = 0
        const val FIFTH_PASSWORD_INDEX = 0
        const val SIXTH_PASSWORD_INDEX = 0
    }
}
