package com.example.vlayouttest.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.layout.StickyLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.view.bean.VLayoutBean

class StickyAdapter(context: Context) :
    BaseVlayoutAdapter<StickyAdapter.MyViewHolder, VLayoutBean>(
        context,
        R.layout.item_linear_view
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = getItemView(parent)
        item.setBackgroundColor(Color.parseColor("#e5e5e5"))
        return MyViewHolder(item)
    }

    override fun onCreateLayoutHelper() = StickyLayoutHelper()

    override fun onBindViewHolder(holder: MyViewHolder, t: VLayoutBean, position: Int) {
        holder.mTv.text = t.text
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.tv)
    }
}