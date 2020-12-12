package com.nhgirls.pockit.ui.categorydetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nhgirls.pockit.R
import com.nhgirls.pockit.data.DummyContainer
import com.nhgirls.pockit.ui.MealkititemDecoration
import com.nhgirls.pockit.utils.dpToPx
import kotlinx.android.synthetic.main.fragment_category_detail.view.*

class CategoryDetailFragment : Fragment() {
    private val viewModel: CategoryDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_detail, container, false)
        val mealkitAdapter = MealkitAdapter(MealkitAdapter.OnClickListener {
            // todo 리사이클러뷰 아이템 클릭시 클릭 이벤트 처리하기
        })
        view.mealkit_list.adapter = mealkitAdapter
        view.mealkit_list.addItemDecoration(
            MealkititemDecoration(
                MEALKIT_LIST_SPANCOUNT,
                MEALKIT_LIST_SPACING
            )
        )

        subscribeUi(mealkitAdapter)
        mealkitAdapter.submitList(DummyContainer.getDummyMealKits())
        return view
    }

    private fun subscribeUi(mealkitAdapter: MealkitAdapter) {
        viewModel.mealKits.observe(viewLifecycleOwner, Observer {
            mealkitAdapter.submitList(it)
        })
    }

    companion object {
        private const val MEALKIT_LIST_SPANCOUNT = 2
        private val MEALKIT_LIST_SPACING = 14.dpToPx()
    }
}
