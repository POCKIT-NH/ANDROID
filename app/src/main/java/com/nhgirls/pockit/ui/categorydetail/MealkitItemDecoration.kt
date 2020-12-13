package com.nhgirls.pockit.ui.categorydetail

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.lang.IndexOutOfBoundsException

class MealkitItemDecoration(private val spanCount: Int, private val spacing: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        outRect.left = getLeftOffset(spacing, column)
        outRect.right = getRightOffset(spacing, column)
    }

    private fun getLeftOffset(spacing: Int, column: Int): Int {
        return when(column){
            FIRST_COLUMN -> spacing
            SECOND_COLUMN -> spacing / 2
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getRightOffset(spacing: Int, column: Int): Int {
        return when(column){
            FIRST_COLUMN -> spacing / 2
            SECOND_COLUMN -> spacing
            else -> throw IndexOutOfBoundsException()
        }
    }

    companion object{
        private const val FIRST_COLUMN = 0
        private const val SECOND_COLUMN = 1
    }
}