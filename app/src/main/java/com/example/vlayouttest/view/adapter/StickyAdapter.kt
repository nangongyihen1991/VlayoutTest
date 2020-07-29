package com.example.vlayouttest.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.layout.StickyLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.manager.Constants

class StickyAdapter(context: Context) :
    BaseCommonVLayoutAdapter<StickyAdapter.MyViewHolder, Unit>(
        context,
        R.layout.item_view
    ) {
    override fun getItemViewType(position: Int): Int {
        return Constants.TYPE_STICKY
    }

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = getItemView(parent)
        item.setBackgroundColor(Color.parseColor("#e5e5e5"))
        return MyViewHolder(item)
    }

    override fun onCreateLayoutHelper() = StickyLayoutHelper()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTv.text = ("StickyAdapter-> ${getAdapterData()?.type}")
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.tv)
    }
}