package com.nhgirls.pockit.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class HomeViewPagerAdapter() : PagerAdapter() {
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int = 4
}