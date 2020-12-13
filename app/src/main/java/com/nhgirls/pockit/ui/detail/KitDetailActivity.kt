package com.nhgirls.pockit.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nhgirls.pockit.R
import kotlinx.android.synthetic.main.kit_detail_bottom_sheet.*

class KitDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kit_detail)

        initViewPager()
    }

    private fun initViewPager(){
        vpKitDetail.adapter = KitDetailInfoViewPagerAdapter()

        vpKitDetail.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tlKitDetail))
        tlKitDetail.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(vpKitDetail))
    }
}