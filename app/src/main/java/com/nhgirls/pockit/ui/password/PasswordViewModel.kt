package com.nhgirls.pockit.ui.password

import androidx.lifecycle.ViewModel

class PasswordViewModel : ViewModel(){
    private val password: MutableList<Int> = MutableList(6) { it }

    fun savePassword(index: Int, password: Int){
        this.password[index] = password
    }

    companion object{
        const val FIRST_PASSWORD_INDEX = 0
        const val SECOND_PASSWORD_INDEX = 0
        const val THIRD_PASSWORD_INDEX = 0
        const val FOURTH_PASSWORD_INDEX = 0
        const val FIFTH_PASSWORD_INDEX = 0
        const val SIXTH_PASSWORD_INDEX = 0
    }
}