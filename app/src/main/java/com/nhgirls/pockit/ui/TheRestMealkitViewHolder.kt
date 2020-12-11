package com.nhgirls.pockit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Mealkit
import com.nhgirls.pockit.databinding.ItemMealkitTherestBinding
import org.jetbrains.annotations.NotNull

class TheRestMealkitViewHolder private constructor(private val binding: @NotNull ItemMealkitTherestBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(mealKit: Mealkit, onClickListener: MealkitAdapter.OnClickListener){

    }

    companion object{
        fun from(viewGroup: ViewGroup): TheRestMealkitViewHolder{
            val binding = ItemMealkitTherestBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
            return TheRestMealkitViewHolder(binding)
        }
    }
}