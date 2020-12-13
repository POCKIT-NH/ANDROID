package com.nhgirls.pockit.ui.story

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.GlideApp
import com.nhgirls.pockit.data.StoryItem
import com.nhgirls.pockit.utils.inflate

class StoryRecyclerAdapter : RecyclerView.Adapter<StoryRecyclerAdapter.ViewHolder>(){

    private var data: List<StoryItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.item_pockit_story))

    fun initData(data: List<StoryItem>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.setIsRecyclable(false)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val imgStory: ImageView = view.findViewById(R.id.imgStory)
        private val txtStoryTitle: TextView = view.findViewById(R.id.txtStoryTitle)
        private val txtStoryTitle2: TextView = view.findViewById(R.id.txtStoryTitle2)
        private val txtStoryDate :TextView = view.findViewById(R.id.txtStoryDate)
        private val txtStoryVisit: TextView = view.findViewById(R.id.txtStoryVisit)

        fun bind(item: StoryItem){
            GlideApp.with(itemView).load(item.img).into(imgStory)
            txtStoryTitle.text = item.title
            txtStoryTitle2.text = item.title2
            txtStoryDate.text = item.date
            txtStoryVisit.text = "${item.visit}"
        }
    }
}