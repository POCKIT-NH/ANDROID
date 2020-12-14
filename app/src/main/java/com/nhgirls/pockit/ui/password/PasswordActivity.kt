package com.nhgirls.pockit.ui.password

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.nhgirls.pockit.R
import com.nhgirls.pockit.generated.callback.OnClickListener
import com.nhgirls.pockit.ui.completeorder.CompleteOrderActivity
import com.nhgirls.pockit.ui.password.PasswordViewModel.Companion.FIFTH_PASSWORD_INDEX
import com.nhgirls.pockit.ui.password.PasswordViewModel.Companion.FIRST_PASSWORD_INDEX
import com.nhgirls.pockit.ui.password.PasswordViewModel.Companion.FOURTH_PASSWORD_INDEX
import com.nhgirls.pockit.ui.password.PasswordViewModel.Companion.SECOND_PASSWORD_INDEX
import com.nhgirls.pockit.ui.password.PasswordViewModel.Companion.SIXTH_PASSWORD_INDEX
import com.nhgirls.pockit.ui.password.PasswordViewModel.Companion.THIRD_PASSWORD_INDEX
import com.nhgirls.pockit.ui.pay.TOTAL_PRICE
import com.nhgirls.pockit.utils.hideKeyboard
import com.nhgirls.pockit.utils.startActivity
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {
    private val viewModel: PasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        password_first.highlightColor = Color.WHITE
        password_first.requestFocus()
        this.hideKeyboard()

        password_first.onFocusChangeListener = onFocusChangedListener
        viewModel.setTotalPrice(this.intent.getIntExtra(TOTAL_PRICE, 0))
        initPinInput()
        initPasswordPad()
        subscribeUi()
    }

    private fun initPinInput() {
        password_first.addTextChangedListener {
            if (it?.isNotEmpty()!!) {
                password_second.requestFocus()
                if (it.toString() != "*") {
                    viewModel.savePassword(FIRST_PASSWORD_INDEX, it.toString().toInt())
                    password_first.setText("*")
                }
            }
        }

        password_second.addTextChangedListener {
            if (it?.isNotEmpty()!!) {
                if (it.toString() != "*") {
                    viewModel.savePassword(SECOND_PASSWORD_INDEX, it.toString().toInt())
                    password_second.setText("*")
                }
                if (it.toString() == "*") {
                    password_third.requestFocus()
                }
                if (it.toString() == "") {
                    password_first.requestFocus()
                }
            }
        }

        password_third.addTextChangedListener {
            if (it?.isNotEmpty()!!) {
                if (it.toString() != "*") {
                    viewModel.savePassword(THIRD_PASSWORD_INDEX, it.toString().toInt())
                    password_third.setText("*")
                }
                if (it.toString() == "*") {
                    password_fourth.requestFocus()
                }
                if (it.toString() == "") {
                    password_second.requestFocus()
                }
            }
        }

        password_fourth.addTextChangedListener {
            if (it?.isNotEmpty()!!) {
                if (it.toString() != "*") {
                    viewModel.savePassword(FOURTH_PASSWORD_INDEX, it.toString().toInt())
                    password_fourth.setText("*")
                }
                if (it.toString() == "*") {
                    password_fifth.requestFocus()
                }
                if (it.toString() == "") {
                    password_third.requestFocus()
                }
            }
        }

        password_fifth.addTextChangedListener {
            if (it?.isNotEmpty()!!) {
                if (it.toString() != "*") {
                    viewModel.savePassword(FIFTH_PASSWORD_INDEX, it.toString().toInt())
                    password_fifth.setText("*")
                    password_sixth.requestFocus()
                }
                if (it.toString() == "*") {
                    password_sixth.requestFocus()
                }
                if (it.toString() == "") {
                    password_fourth.requestFocus()
                }
            }
        }

        password_sixth.addTextChangedListener {
            if (it?.isNotEmpty()!!) {
                if (it.toString() != "*") {
                    viewModel.savePassword(SIXTH_PASSWORD_INDEX, it.toString().toInt())
                }
                viewModel.postNhPay()
                password_fifth.setText("*")
            }
        }
    }

    private fun goCompleteOrderActivity() {
        val intent = Intent(this, CompleteOrderActivity::class.java)
        intent.putExtra(TOTAL_PRICE, viewModel.getTotalPrice())
        startActivity(intent)
        finish()
    }

    private fun initPasswordPad() {
        one.setOnClickListener(onClickListener)
        two.setOnClickListener(onClickListener)
        three.setOnClickListener(onClickListener)
        four.setOnClickListener(onClickListener)
        five.setOnClickListener(onClickListener)
        six.setOnClickListener(onClickListener)
        seven.setOnClickListener(onClickListener)
        eight.setOnClickListener(onClickListener)
        nine.setOnClickListener(onClickListener)
        zero.setOnClickListener(onClickListener)
    }

    private val onFocusChangedListener = View.OnFocusChangeListener { view, ifHasFocus ->
        when (view?.id) {
            R.id.password_first -> this@PasswordActivity.hideKeyboard()
            R.id.password_second -> this@PasswordActivity.hideKeyboard()
            R.id.password_third -> this@PasswordActivity.hideKeyboard()
            R.id.password_fourth -> this@PasswordActivity.hideKeyboard()
            R.id.password_fifth -> this@PasswordActivity.hideKeyboard()
            R.id.password_sixth -> this@PasswordActivity.hideKeyboard()
        }
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.one -> {
                detectOneHasFocus().text = "1"
            }
            R.id.two -> {
                detectOneHasFocus().text = "2"
            }
            R.id.three -> {
                detectOneHasFocus().text = "3"
            }
            R.id.four -> {
                detectOneHasFocus().text = "4"
            }
            R.id.five -> {
                detectOneHasFocus().text = "5"
            }
            R.id.six -> {
                detectOneHasFocus().text = "6"
            }
            R.id.six -> {
                detectOneHasFocus().text = "6"
            }
            R.id.seven -> {
                detectOneHasFocus().text = "7"
            }
            R.id.eight -> {
                detectOneHasFocus().text = "8"
            }
            R.id.nine -> {
                detectOneHasFocus().text = "9"
            }
            R.id.zero -> {
                detectOneHasFocus().text = "0"
            }
        }

    }

    private fun detectOneHasFocus(): TextView {
        return when {
            password_first.hasFocus() -> {
                password_first
            }
            password_second.hasFocus() -> {
                password_second
            }
            password_third.hasFocus() -> {
                password_third
            }
            password_fourth.hasFocus() -> {
                password_fourth
            }
            password_fifth.hasFocus() -> {
                password_fifth
            }
            password_sixth.hasFocus() -> {
                password_sixth
            }
            else -> {
                throw IllegalStateException("Pin 번호 입력 칸에 초점이 맞춰져 있어야 합니다.")
            }
        }
    }

    private fun subscribeUi() {
        viewModel.goCompleteOrder.observe(this, Observer {
            if (it) {
                goCompleteOrderActivity()
            }
        })
    }
}
