package com.nhgirls.pockit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.nhgirls.pockit.R


const val KOREAN_MEAL_SET = 0
const val KOREAN_SIDE_DISH = 1
const val CONVENIENT_FOOD = 2
const val NIGHT_FOOD = 3
const val WESTERN_FOOD= 4
const val JAPANESS_FOOD = 5
const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1


class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        return view
    }
}
