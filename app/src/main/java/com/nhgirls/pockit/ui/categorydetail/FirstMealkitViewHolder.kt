package com.nhgirls.pockit.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Mealkit
import com.nhgirls.pockit.databinding.ItemMealkitFirstBinding
import com.nhgirls.pockit.utils.setRound

import org.jetbrains.annotations.NotNull

class FirstMealkitViewHolder private constructor(private val binding: @NotNull ItemMealkitFirstBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(mealKit: Mealkit, onClickListener: MealkitAdapter.OnClickListener) {
        binding.mealKit = mealKit
        binding.onClickListener = onClickListener
    }

    companion object {
        private const val ROOT_CORNER_RADIUS = 9.5f
        private const val IMAGE_CORNER_RADIUS = 9.0f
        fun from(viewGroup: ViewGroup): FirstMealkitViewHolder {
            val binding = ItemMealkitFirstBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            giveCornerRadius(binding)
            return FirstMealkitViewHolder(binding)
        }

        private fun giveCornerRadius(binding: ItemMealkitFirstBinding) {
            binding.root.setRound(ROOT_CORNER_RADIUS)
            binding.image.setRound(IMAGE_CORNER_RADIUS)
        }
    }
}
