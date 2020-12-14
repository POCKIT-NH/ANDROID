package com.nhgirls.pockit.ui.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.HorizontalItemDecorator
import com.nhgirls.pockit.data.response.TodayPockitResponse
import com.nhgirls.pockit.ui.home.TodayPockitRecyclerAdapter
import kotlinx.android.synthetic.main.activity_story_detail.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_story.*

class StoryDetailActivity : AppCompatActivity() {

    private var mock = listOf(
        TodayPockitResponse("https://sopt-server-27.s3.ap-northeast-2.amazonaws.com/4.jpg","단호박 크림 파스타",12000, 86),
        TodayPockitResponse("https://sopt-server-27.s3.ap-northeast-2.amazonaws.com/4.jpg","단호박 해물 찜",13200, 45),
        TodayPockitResponse("https://sopt-server-27.s3.ap-northeast-2.amazonaws.com/4.jpg","단호박 전",9500, 21)
    )

    private lateinit var todayPockitAdapter: TodayPockitRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_detail)

        initRecycler()
    }

    private fun initRecycler(){
        todayPockitAdapter = TodayPockitRecyclerAdapter()
        rvStoryPockit.apply{
            adapter = todayPockitAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
        todayPockitAdapter.initData(mock)
    }
}