package com.nhgirls.pockit.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Cart
import com.nhgirls.pockit.databinding.ItemCartBinding
import com.nhgirls.pockit.utils.setRound
import org.jetbrains.annotations.NotNull

class CartViewHolder private constructor(
    private val binding: @NotNull ItemCartBinding,
    private val onClickListener: CartAdapter.OnClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(cart: Cart) {
        binding.cart = cart
        binding.onClick = onClickListener
    }

    companion object {
        private const val CORNER_RADIUS = 18f
        private const val IMAGE_CORNER_RADIUS = 16f

        fun from(viewGroup: ViewGroup, onClickListener: CartAdapter.OnClickListener): CartViewHolder {
            val binding = ItemCartBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            giveCornerRadius(binding)
            return CartViewHolder(binding, onClickListener)
        }

        private fun giveCornerRadius(binding: ItemCartBinding) {
            binding.root.setRound(CORNER_RADIUS)
            binding.image.setRound(IMAGE_CORNER_RADIUS)
        }
    }
}