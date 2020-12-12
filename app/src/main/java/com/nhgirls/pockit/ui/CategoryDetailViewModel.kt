package com.nhgirls.pockit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.data.DummyContainer
import com.nhgirls.pockit.data.Mealkit

class CategoryDetailViewModel : ViewModel() {
    private val _mealKits = MutableLiveData<List<Mealkit>>()
    val mealKits: LiveData<List<Mealkit>>
        get() = _mealKits

    init {
        _mealKits.value = DummyContainer.getDummyMealKits()
    }
}
