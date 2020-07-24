package com.example.vlayouttest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.view.bean.VLayoutBean

class GridAdapter(context: Context) :
    BaseVLayoutAdapter<GridAdapter.MyViewHolder, VLayoutBean>(
        context,
        R.layout.item_linear_view
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = getItemView(parent)
        return MyViewHolder(itemView)
    }

    override fun onCreateLayoutHelper() = GridLayoutHelper(3, itemCount)

    override fun onBindViewHolder(holder: MyViewHolder, t: VLayoutBean, position: Int) {
        holder.mTv.text = t.text
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.tv)
    }
}