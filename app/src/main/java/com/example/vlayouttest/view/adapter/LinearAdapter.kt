package com.example.vlayouttest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.view.bean.VLayoutBean

class LinearAdapter(context: Context) :
    BaseVLayoutAdapter<LinearAdapter.MyViewHolder, VLayoutBean>(
        context,
        R.layout.item_linear_view
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(getItemView(parent))
    }

    override fun onCreateLayoutHelper() = LinearLayoutHelper(0, itemCount)

    override fun onBindViewHolder(holder: MyViewHolder, t: VLayoutBean, position: Int) {
        holder.mTv.text = t.text
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.tv)
    }
}