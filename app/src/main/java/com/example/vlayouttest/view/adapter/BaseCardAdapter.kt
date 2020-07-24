package com.example.vlayouttest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.LayoutHelper
import com.example.vlayouttest.R

class BaseCardAdapter<VH : BaseCardAdapter.BaseViewHolder, VLayoutBean>(context: Context) :
    BaseVlayoutAdapter<VH, VLayoutBean>(
        context,
        R.layout.view_card_item
    ) {


    override fun onBindViewHolder(holder: VH, t: VLayoutBean, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        TODO("Not yet implemented")
    }


    open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mViewCardTop: FrameLayout = itemView.findViewById(R.id.card_top)
        val mViewCardContent: FrameLayout = itemView.findViewById(R.id.card_content)
        val mViewCardBottom: FrameLayout = itemView.findViewById(R.id.card_bottom)
    }
}