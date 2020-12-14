package com.nhgirls.pockit.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Card
import com.nhgirls.pockit.databinding.ItemPlusCardBinding
import org.jetbrains.annotations.NotNull

class PlusCardViewHolder(
    val binding: @NotNull ItemPlusCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(card: Card) {
    }

    companion object {
        fun from(
            viewGroup: ViewGroup
        ): PlusCardViewHolder {
            val binding = ItemPlusCardBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            return PlusCardViewHolder(binding)
        }
    }
}
