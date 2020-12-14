package com.nhgirls.pockit.ui.pay

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Card
import com.nhgirls.pockit.ui.cart.CardViewHolder
import com.nhgirls.pockit.ui.cart.PlusCardViewHolder
import java.lang.IllegalArgumentException

private const val ITEM_CARD_INDEX = 0
private const val ITEM_CARD_VIEW_TYPE = 0

private const val ITEM_PLUS_CARD_VIEW_TYPE = 1


class PayAdatper(private val onClickListener: OnClickListener) :
    ListAdapter<Card, RecyclerView.ViewHolder>(DiffCallback) {

    override fun getItemViewType(position: Int): Int {
        return if(position == ITEM_CARD_INDEX){
            ITEM_CARD_VIEW_TYPE
        }else{
            ITEM_PLUS_CARD_VIEW_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_CARD_VIEW_TYPE -> CardViewHolder.from(parent, onClickListener)
            ITEM_PLUS_CARD_VIEW_TYPE -> PlusCardViewHolder.from(parent)
            else -> throw IllegalArgumentException("잘못된 viewType 입니다. 잘못된 viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == ITEM_CARD_INDEX){
            (holder as CardViewHolder).bind(getItem(position))
        }else{
            (holder as PlusCardViewHolder).bind(getItem(position))
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(private val clickListener: (view: View, card: Card) -> Unit) {
        fun onClick(view: View, card: Card) = clickListener(view, card)
    }
}
