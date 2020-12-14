package com.nhgirls.pockit.ui.completeorder

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nhgirls.pockit.R
import com.nhgirls.pockit.databinding.ActivityCompleteOrderBinding
import com.nhgirls.pockit.ui.pay.TOTAL_PRICE

class CompleteOrderActivity : AppCompatActivity() {
    private val viewModel: CompleteOrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCompleteOrderBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_complete_order)
        binding.viewModel = viewModel
        viewModel.setTotalPrice(intent.getIntExtra(TOTAL_PRICE, 0))
        binding.confirm.setOnClickListener { finish() }
    }
}