package com.example.vlayouttest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.manager.Constants
import com.example.vlayouttest.view.bean.TestBean

class LinearAdapter(context: Context) :
    BaseCommonVLayoutAdapter<LinearAdapter.MyViewHolder, TestBean>(
        context,
        R.layout.item_view
    ) {
    override fun getItemViewType(position: Int): Int {
        return Constants.TYPE_LINEAR
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(getItemView(parent))
    }

    override fun onCreateLayoutHelper() = LinearLayoutHelper(0, itemCount)

    override fun onBindViewHolder(holder: MyViewHolder, t: TestBean, position: Int) {
        holder.mTv.text = t.text
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.tv)
    }
}