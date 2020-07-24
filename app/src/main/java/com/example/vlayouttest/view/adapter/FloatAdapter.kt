package com.example.vlayouttest.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.layout.FixLayoutHelper
import com.alibaba.android.vlayout.layout.FloatLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.view.bean.VLayoutBean

class FloatAdapter(context: Context) :
    BaseVLayoutAdapter<FloatAdapter.MyViewHolder, VLayoutBean>(
        context,
        R.layout.item_linear_view
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = getItemView(parent)
        item.layoutParams = item.layoutParams.also {
            it.width = 200
            it.height = 200
        }
        item.setBackgroundColor(Color.parseColor("#ff00ff"))
        return MyViewHolder(item)
    }

    override fun onCreateLayoutHelper() = FloatLayoutHelper().also {
        it.setAlignType(FixLayoutHelper.BOTTOM_RIGHT)
        it.setDefaultLocation(20, 20)
    }

    override fun onBindViewHolder(holder: MyViewHolder, t: VLayoutBean, position: Int) {
        holder.mTv.text = t.text
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.tv)
    }
}