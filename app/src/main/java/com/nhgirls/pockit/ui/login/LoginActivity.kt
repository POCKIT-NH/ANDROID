package com.nhgirls.pockit.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.setOnDebounceClickListener
import com.nhgirls.pockit.data.requesst.LoginRequest
import com.nhgirls.pockit.ui.MainActivity
import com.nhgirls.pockit.utils.startActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val vm : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initSetting()
        initObserve()
        login()

    }

    private fun initSetting(){
        edtLoginId.text = Editable.Factory.getInstance().newEditable("test@naver.com")
        edtLoginPw.text = Editable.Factory.getInstance().newEditable("1234")
    }


    private fun initObserve(){
        vm.isSuccessPostLogin.observe(this, Observer { isSuccess ->
            if(isSuccess) {
                startActivity(MainActivity::class,true)
            } else {
                Toast.makeText(this, "로그인/비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun login(){
        txtLoginBtn.setOnDebounceClickListener {
            vm.login(LoginRequest(edtLoginId.text.toString(), edtLoginPw.text.toString()))
        }
    }
}