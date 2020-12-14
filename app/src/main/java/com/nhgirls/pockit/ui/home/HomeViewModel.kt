package com.nhgirls.pockit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.api.Service
import com.nhgirls.pockit.data.response.TodayPriceResponse
import com.nhgirls.pockit.utils.safeEnqueue

class HomeViewModel : ViewModel() {

    private val api = Service.service

    private val _todayPriceList: MutableLiveData<List<TodayPriceResponse>> = MutableLiveData()
    val todayPriceList: LiveData<List<TodayPriceResponse>> = _todayPriceList

    fun getTodayPriceList(){
        api.getTodayPrice().safeEnqueue(
            onSuccess = {
                _todayPriceList.value = it.data
            },
            onFailure = {
                _todayPriceList.value = null
            },
            onError = {
                _todayPriceList.value = null
            }
        )
    }

}