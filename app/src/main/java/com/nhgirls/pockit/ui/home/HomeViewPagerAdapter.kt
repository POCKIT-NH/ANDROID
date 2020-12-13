package com.nhgirls.pockit.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.nhgirls.pockit.R
import kotlinx.android.synthetic.main.item_today_price.view.*

class HomeViewPagerAdapter : PagerAdapter() {

    private val mock = listOf(
        TodayPrice(R.drawable.dummy_mealkit_1,"샐러드","12,000원","9,000원"),
        TodayPrice(R.drawable.dummy_mealkit_2,"샐러드","12,000원","9,000원"),
        TodayPrice(R.drawable.dummy_mealkit_3,"샐러드","12,000원","9,000원"),
        TodayPrice(R.drawable.dummy_mealkit_4,"샐러드","12,000원","9,000원")
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_today_price, container, false)

        view.imgTodayKit.setImageResource(mock[position].img!!)
        view.txtKitName.text = mock[position].kitName
        view.txtKitPrice.text = mock[position].kitPrice
        view.txtSalePrice.text = mock[position].kitSalePrice

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

    data class TodayPrice(
        val img: Int?,
        val kitName: String,
        val kitPrice: String,
        val kitSalePrice: String
    )
}