package com.nhgirls.pockit.ui.forest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.api.Service
import com.nhgirls.pockit.utils.safeEnqueue

class ForestViewModel : ViewModel() {
    private val _forestPercent = MutableLiveData(0)
    val forestPercent: LiveData<Int>
        get() = _forestPercent

    init {
        Service.service.getForest().safeEnqueue(
            {},
            { _forestPercent.value = it.data },
            {}
        )
    }
}