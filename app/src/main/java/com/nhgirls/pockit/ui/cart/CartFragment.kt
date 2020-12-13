package com.nhgirls.pockit.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nhgirls.pockit.R
import com.nhgirls.pockit.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCartBinding.inflate(inflater, container, false)
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


        subscribeUi(binding, cartAdapter)
        return binding.root
    }

    private fun subscribeUi(binding: FragmentCartBinding, cartAdapter: CartAdapter) {
        viewModel.cartList.observe(viewLifecycleOwner, Observer {
            cartAdapter.submitList(it)
        })

        viewModel.ifAllChecked.observe(viewLifecycleOwner, Observer {
            binding.selectAll.isChecked = it
        })
    }
}
