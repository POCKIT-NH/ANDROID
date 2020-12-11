package com.nhgirls.pockit.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

const val KOREAN_MEAL_SET = 0
const val KOREAN_SIDE_DISH = 1
const val CONVENIENT_FOOD = 2
const val NIGHT_FOOD = 3
const val WESTERN_FOOD = 4
const val JAPANESE_FOOD = 5
const val FRUIT = 6
const val ETC = 7

class CategoryPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        KOREAN_MEAL_SET to { CategoryDetailFragment() },
        KOREAN_SIDE_DISH to { CategoryDetailFragment() },
        CONVENIENT_FOOD to { CategoryDetailFragment() },
        NIGHT_FOOD to { CategoryDetailFragment() },
        WESTERN_FOOD to { CategoryDetailFragment() },
        JAPANESE_FOOD to { CategoryDetailFragment() },
        FRUIT to { CategoryDetailFragment() },
        ETC to { CategoryDetailFragment() }
    )

    override fun getItemCount(): Int = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}
