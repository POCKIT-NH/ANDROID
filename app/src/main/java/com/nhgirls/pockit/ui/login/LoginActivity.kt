package com.nhgirls.pockit.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.setOnDebounceClickListener
import com.nhgirls.pockit.ui.MainActivity
import com.nhgirls.pockit.utils.startActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtLoginId.text = Editable.Factory.getInstance().newEditable("ddd")
        edtLoginPw.text = Editable.Factory.getInstance().newEditable("ddd")

        txtLoginBtn.setOnDebounceClickListener {
            startActivity(MainActivity::class,true)
        }
    }
}