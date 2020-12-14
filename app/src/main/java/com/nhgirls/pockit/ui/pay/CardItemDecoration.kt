package com.nhgirls.pockit.ui.pay

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nhgirls.pockit.utils.dpToPx

class CardItemDecoration() :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if(position == FIRST_COLUMN){
            outRect.left = FIRST_ITEM_LEFT_MARGIN
        }else{
            outRect.left = THE_REST_ITEM_LEFT_MARGIN
            outRect.right = LAST_ITEM_RIGHT_MARGIN
        }
    }

    companion object{
        private const val FIRST_COLUMN = 0
        private val FIRST_ITEM_LEFT_MARGIN = 57.dpToPx()
        private val THE_REST_ITEM_LEFT_MARGIN = 25.dpToPx()
        private val LAST_ITEM_RIGHT_MARGIN = 57.dpToPx()
    }
}