package com.nhgirls.pockit.ui.home

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.PockitApplication.Companion.GlobalApp
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.GlideApp
import com.nhgirls.pockit.common.setOnDebounceClickListener
import com.nhgirls.pockit.data.response.TodayPockitResponse
import com.nhgirls.pockit.ui.detail.KitDetailActivity
import com.nhgirls.pockit.utils.inflate

class TodayPockitRecyclerAdapter : RecyclerView.Adapter<TodayPockitRecyclerAdapter.ViewHolder>(){

    private var data: List<TodayPockitResponse> = emptyList()

    fun initData(data: List<TodayPockitResponse>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.item_today_pockit))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val imgTodayPockit : ImageView = itemView.findViewById(R.id.imgTodayKit)
        private val txtTodayPockitName : TextView = itemView.findViewById(R.id.txtTodayPockitName)
        private val txtTodayPockitPrice : TextView = itemView.findViewById(R.id.txtTodayPockitPrice)
        private val txtTodayPockitLike : TextView = itemView.findViewById(R.id.txtTodayPockitLike)

        fun bind(item: TodayPockitResponse){
//            GlideApp.with(itemView).load(item.imageUrl).into(imgTodayPockit)
            txtTodayPockitName.text = item.title
            txtTodayPockitPrice.text = "${item.price}원"
            txtTodayPockitLike.text = "${item.like}명이 포크로 찜했어요"

            itemView.setOnDebounceClickListener {
                Intent(GlobalApp,KitDetailActivity::class.java).apply {
                    putExtra("idx",9)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { GlobalApp.startActivity(this) }
            }
        }
    }
}