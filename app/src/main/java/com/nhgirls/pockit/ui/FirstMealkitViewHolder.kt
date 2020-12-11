package com.nhgirls.pockit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Mealkit
import com.nhgirls.pockit.databinding.ItemMealkitFirstBinding

import org.jetbrains.annotations.NotNull

class FirstMealkitViewHolder private constructor(private val binding: @NotNull ItemMealkitFirstBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(mealKit: Mealkit, onClickListener: MealkitAdapter.OnClickListener){

    }

    companion object{
        fun from(viewGroup: ViewGroup): FirstMealkitViewHolder{
            val binding = ItemMealkitFirstBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            return FirstMealkitViewHolder(binding)
        }
    }
}