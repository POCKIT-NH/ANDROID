package com.nhgirls.pockit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Mealkit
import com.nhgirls.pockit.databinding.ItemMealkitTherestBinding
import com.nhgirls.pockit.utils.setRound
import org.jetbrains.annotations.NotNull

class TheRestMealkitViewHolder private constructor(private val binding: @NotNull ItemMealkitTherestBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(mealKit: Mealkit, onClickListener: MealkitAdapter.OnClickListener){
        binding.mealKit = mealKit
    }

    companion object{
        private const val CORNER_RADIUS = 9.5f
        private const val IMAGE_CORNER_RADIUS = 9.0f
        fun from(viewGroup: ViewGroup): TheRestMealkitViewHolder{
            val binding = ItemMealkitTherestBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            giveCornerRadius(binding)
            return TheRestMealkitViewHolder(binding)
        }
        private fun giveCornerRadius(binding: ItemMealkitTherestBinding) {
            binding.root.setRound(CORNER_RADIUS)
            binding.image.setRound(IMAGE_CORNER_RADIUS)
        }
    }
}