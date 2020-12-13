package com.nhgirls.pockit.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.nhgirls.pockit.R
import kotlinx.android.synthetic.main.item_kit_detail.view.*

class KitDetailInfoViewPagerAdapter: PagerAdapter(){

    private val mock = listOf(
        R.drawable.dummy_mealkit_1,
        R.drawable.dummy_mealkit_2,
        R.drawable.dummy_mealkit_3,
        R.drawable.dummy_mealkit_4
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_kit_detail, container, false)

        view.imgKitDetailInfo.setImageResource(mock[position])

        container.addView(view)

        return view
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int = 4
}