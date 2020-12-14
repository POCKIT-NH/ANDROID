package com.nhgirls.pockit.ui.categorydetail

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.data.Mealkit

private const val FIRST_MEAL_INDEX = 0
private const val FIRST_MEAL_VIEW_TYPE = 1
private const val THE_REST_MEAL_VIEW_TYPE = 2

class MealkitAdapter(private val onClickListener: OnClickListener) :
    androidx.recyclerview.widget.ListAdapter<Mealkit, RecyclerView.ViewHolder>(DiffCallback) {
    override fun getItemViewType(position: Int): Int {
        return if (position == FIRST_MEAL_INDEX) {
            FIRST_MEAL_VIEW_TYPE
        } else {
            THE_REST_MEAL_VIEW_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == FIRST_MEAL_VIEW_TYPE) {
            FirstMealkitViewHolder.from(parent)
        } else {
            TheRestMealkitViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == FIRST_MEAL_VIEW_TYPE) {
            (holder as FirstMealkitViewHolder).bind(getItem(position), onClickListener)
        } else {
            (holder as TheRestMealkitViewHolder).bind(getItem(position), onClickListener)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Mealkit>() {
        override fun areItemsTheSame(oldItem: Mealkit, newItem: Mealkit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Mealkit, newItem: Mealkit): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(private val clickListener: (mealKit: Mealkit) -> Unit) {
        fun onClick(mealKit: Mealkit) = clickListener(mealKit)
    }
}
