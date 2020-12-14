package com.nhgirls.pockit.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.HorizontalItemDecorator
import com.nhgirls.pockit.data.response.TodayPockitResponse
import com.nhgirls.pockit.data.response.TodayPriceResponse
import com.nhgirls.pockit.ui.cart.CartActivity
import com.nhgirls.pockit.utils.fadeInWithVisible
import com.nhgirls.pockit.utils.setInvisible
import com.nhgirls.pockit.utils.startActivity
import kotlinx.android.synthetic.main.fragment_home.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val vm : HomeViewModel by viewModels()

    private var mock = listOf(
        TodayPockitResponse("https://sopt-server-27.s3.ap-northeast-2.amazonaws.com/4.jpg","장어",1000, 86),
        TodayPockitResponse("https://sopt-server-27.s3.ap-northeast-2.amazonaws.com/4.jpg","월계수잎",1000, 86),
        TodayPockitResponse("https://sopt-server-27.s3.ap-northeast-2.amazonaws.com/4.jpg","보쌈",1000, 86)
    )

    private lateinit var todayPockitAdapter: TodayPockitRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTodayPriceList()
        initRecycler()
        initObserve()
        setImgShoppingCartListener()
    }

    private fun setImgShoppingCartListener(){
        imgShoppingCart.setOnClickListener  {this.startActivity(CartActivity::class) }
    }

    private fun getTodayPriceList(){
        vm.getTodayPriceList()
    }

    private fun initObserve(){
        vm.todayPriceList.observe(viewLifecycleOwner, Observer { data ->
            if(data == null) {
                Toast.makeText(context, "네트워크 에러 발생", Toast.LENGTH_SHORT).show()
            } else {
                rootHome.fadeInWithVisible(600)
                initViewPager(data)
            }
        })
    }

    private fun initRecycler(){
        todayPockitAdapter = TodayPockitRecyclerAdapter()
        rvTodayPockit.apply{
            adapter = todayPockitAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
        todayPockitAdapter.initData(mock)
    }

    private fun initViewPager(data: List<TodayPriceResponse>){
        vpTodayPrice.adapter = HomeViewPagerAdapter(data)

        vpTodayPrice.offscreenPageLimit = 3
        tlTodayPrice.setViewPager(vpTodayPrice)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}