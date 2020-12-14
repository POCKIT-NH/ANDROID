package com.nhgirls.pockit.ui.story

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.HorizontalItemDecorator
import com.nhgirls.pockit.data.StoryItem
import kotlinx.android.synthetic.main.fragment_story.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StoryFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null


    private val data = listOf(
        StoryItem(R.drawable.pockit_story_1,"20-30대 청년 농부의","땀과 노력의 결실을 맺다","2020-12-12",6),
        StoryItem(R.drawable.pockit_story_2,"게임 디자이너에서","미니 단호박 만렙 농부로 !","2020-12-13",3),
        StoryItem(R.drawable.pockit_story_3,"강원도 영월의 기토","기똥찬 토마로 브랜딩","2020-12-13",9)
    )
    private lateinit var storyRecyclerAdapter: StoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler(){
        storyRecyclerAdapter = StoryRecyclerAdapter()

        rvPockitStory.apply {
            adapter =storyRecyclerAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }

        storyRecyclerAdapter.initData(data)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}