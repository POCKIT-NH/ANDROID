package com.nhgirls.pockit.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.nhgirls.pockit.R
import com.nhgirls.pockit.databinding.ActivityCartBinding
import com.nhgirls.pockit.ui.pay.PayActivity
import com.nhgirls.pockit.ui.pay.TOTAL_PRICE

class CartActivity : AppCompatActivity() {
    private val viewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCartBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_cart)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val cartAdapter = CartAdapter(CartAdapter.OnClickListener { view, cart ->
            when (view.id) {
                R.id.root -> {
                    viewModel.toggle(cart)
                    viewModel.calculateTotalPrice()
                }
                R.id.check -> {
                    viewModel.checkIfAllSelected()
                    viewModel.calculateTotalPrice()
                }
                R.id.ex -> {
                    viewModel.remove(cart)
                }
                R.id.icon_count_left -> {
                    viewModel.decreaseCount(cart)
                }
                R.id.icon_count_right -> {
                    viewModel.increaseCount(cart)
                }
            }
        })

        binding.cartList.adapter = cartAdapter
        binding.selectAll.setOnClickListener {
            viewModel.checkAll(binding.selectAll.isChecked)
            viewModel.calculateTotalPrice()
        }

        binding.payCart.setOnClickListener {
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtra(TOTAL_PRICE, viewModel.totalPrice.value)
            startActivity(intent)
            finish()
        }
        subscribeUi(binding, cartAdapter)
    }


    private fun subscribeUi(binding: ActivityCartBinding, cartAdapter: CartAdapter) {
        viewModel.cartList.observe(this, Observer {
            cartAdapter.submitList(it)
        })

        viewModel.ifAllChecked.observe(this, Observer {
            binding.selectAll.isChecked = it
        })
    }
}