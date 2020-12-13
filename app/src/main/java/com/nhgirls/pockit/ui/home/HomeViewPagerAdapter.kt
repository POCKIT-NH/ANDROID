package com.nhgirls.pockit.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.GlideApp
import com.nhgirls.pockit.data.response.TodayPriceResponse
import com.nhgirls.pockit.utils.dpToPx
import com.nhgirls.pockit.utils.setRound
import kotlinx.android.synthetic.main.item_today_price.view.*

class HomeViewPagerAdapter(private val data: List<TodayPriceResponse>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_today_price, container, false)

        GlideApp.with(view).load(data[position].product_img).into(view.imgTodayKit)
        view.imgTodayKit.setRound(10.dpToPx().toFloat())
        view.txtKitName.text = data[position].title
        view.txtKitPrice.text = "${data[position].price}원"
        view.txtSalePrice.text = "${data[position].price - 1030}원"


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