package com.nhgirls.pockit.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class HomeViewPagerAdapter(val data: List<>) : PagerAdapter() {
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        super.destroyItem(container, position, obj)
        container.removeView(obj as View)
    }

    override fun getCount(): Int = 4
}