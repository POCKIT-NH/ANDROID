package com.nhgirls.pockit.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Card
import com.nhgirls.pockit.databinding.ItemCardBinding
import com.nhgirls.pockit.ui.pay.PayAdatper
import org.jetbrains.annotations.NotNull

class CardViewHolder(
    private val binding: @NotNull ItemCardBinding,
    private val onClickListener: PayAdatper.OnClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(card: Card) {
        binding.card = card
        binding.onClick = onClickListener
    }

    companion object{
        fun from(viewGroup: ViewGroup, onClickListener: PayAdatper.OnClickListener): CardViewHolder{
            val binding = ItemCardBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            return CardViewHolder(binding, onClickListener)
        }
    }
}
