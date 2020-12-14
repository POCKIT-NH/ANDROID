package com.nhgirls.pockit.ui.pay

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.R
import com.nhgirls.pockit.databinding.ActivityPayBinding
import com.nhgirls.pockit.ui.password.PasswordActivity


const val TOTAL_PRICE = "total_price"

class PayActivity : AppCompatActivity() {

    private val viewModel: PayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPayBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_pay)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = PayAdatper(PayAdatper.OnClickListener { _, card ->
            viewModel.checkCard(card)
        })
        binding.cardList.adapter = adapter
        binding.cardList.addItemDecoration(CardItemDecoration())
        binding.pay.setOnClickListener {
            val intent = Intent(this, PasswordActivity::class.java)
            intent.putExtra(TOTAL_PRICE, viewModel.totalPrice.value)
            startActivity(intent)
        }

        viewModel.setTotalPrice(intent.getIntExtra(TOTAL_PRICE, 0))

        ResourcesCompat.getDrawable(
            resources,
            R.drawable.bg_pay_button,
            null
        )?.let {
            binding.pay.background = it
        }

        subscribeUi(binding.cardList, adapter)
    }

    private fun subscribeUi(cardList: RecyclerView, adapter: PayAdatper) {
        viewModel.cardList.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}