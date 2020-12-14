package com.nhgirls.pockit.ui.cart

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nhgirls.pockit.data.Cart


class CartAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Cart, CartViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder.from(parent, onClickListener)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(private val clickListener: (view: View, artist: Cart) -> Unit) {
        fun onClick(view: View, artist: Cart) = clickListener(view, artist)
    }
}
