package com.nhgirls.pockit.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nhgirls.pockit.R
import com.nhgirls.pockit.api.Service
import com.nhgirls.pockit.common.GlideApp
import com.nhgirls.pockit.common.setOnDebounceClickListener
import com.nhgirls.pockit.data.requesst.PutCart
import com.nhgirls.pockit.utils.safeEnqueue
import kotlinx.android.synthetic.main.activity_kit_detail.*
import kotlinx.android.synthetic.main.item_today_price.*
import kotlinx.android.synthetic.main.kit_detail_bottom_sheet.*

class KitDetailActivity : AppCompatActivity() {

    private val api = Service.service
    private var idx = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kit_detail)

        initViewPager()

        idx = intent.getIntExtra("idx", 0)

        initDetail()

        txtDetailCart.setOnDebounceClickListener {
            api.postCart(PutCart(1,idx)).safeEnqueue(
                onSuccess = {
                    var toast = Toast(applicationContext)
                    toast.setGravity(Gravity.CENTER,0,0)
                    toast.duration = Toast.LENGTH_SHORT
                    toast.view = layoutInflater.inflate(R.layout.cart_toast,null)
                    toast.show()
                },
                onFailure = {

                },
                onError = {

                }
            )
        }
    }

    private fun initViewPager(){
        vpKitDetail.adapter = KitDetailInfoViewPagerAdapter()

        vpKitDetail.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tlKitDetail))
        tlKitDetail.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(vpKitDetail))
    }

    private fun initDetail(){
        api.getPockitDetail(idx).safeEnqueue(
            onSuccess = {
                GlideApp.with(this).load(it.data.product_img).into(imgDetailFood)
                txtDetailTitle.text = it.data.title

                txtDetailPrice.text = "${it.data.price}원"

                if(idx == 13){
                    txtAvg.text = "4.2"
                    txtDetailMaterial.text = "콩비지, 묵은 김치, 돼지 등심, 삼겹살, 꽈리고추"
                    txtDetailCookTime.text = "45분"
                    txtDetailLevelTime.text = "중"
                }else{
                    txtAvg.text = "4.7"
                    txtDetailMaterial.text = "단호박, 유기농 파스타, 양파, 당근, 브로콜리"
                    txtDetailCookTime.text = "30분"
                    txtDetailLevelTime.text = "하"
                }
            },
            onError = {

            },
            onFailure = {

            }
        )


    }
}