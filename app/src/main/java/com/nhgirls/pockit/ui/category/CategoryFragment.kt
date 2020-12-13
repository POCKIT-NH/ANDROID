package com.nhgirls.pockit.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.nhgirls.pockit.R
import kotlinx.android.synthetic.main.fragment_category.view.*


class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.viewpager.adapter = CategoryPagerAdapter(this)
        TabLayoutMediator(view.tabs, view.viewpager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            KOREAN_MEAL_SET -> getString(R.string.korean_meal_title)
            KOREAN_SIDE_DISH -> getString(R.string.korean_side_title)
            CONVENIENT_FOOD -> getString(R.string.convenient_food_title)
            NIGHT_FOOD -> getString(R.string.night_food_title)
            WESTERN_FOOD -> getString(R.string.western_food_title)
            JAPANESE_FOOD -> getString(R.string.japanese_food_title)
            FRUIT -> getString(R.string.fruit_title)
            ETC -> getString(R.string.etc_title)
            else -> null
        }
    }
}
