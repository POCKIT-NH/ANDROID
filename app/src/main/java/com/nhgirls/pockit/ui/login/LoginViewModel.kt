package com.nhgirls.pockit.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhgirls.pockit.api.ServiceApi
import com.nhgirls.pockit.data.requesst.LoginRequest
import com.nhgirls.pockit.utils.safeEnqueue

class LoginViewModel(private val api: ServiceApi): ViewModel() {
    private val _login: MutableLiveData<List<LoginRequest>?> = MutableLiveData()
    val login: LiveData<List<LoginRequest>?> = _login

    private val _isSuccessPostLogin: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessPostLogin: LiveData<Boolean> = _isSuccessPostLogin

    fun login(login: LoginRequest){
        api.postLogin(login).safeEnqueue(
            onSuccess = {
                _isSuccessPostLogin.value = true
            },
            onFailure = {
                _isSuccessPostLogin.value = false
            },
            onError = {
                _isSuccessPostLogin.value = false
            }
        )
    }
}