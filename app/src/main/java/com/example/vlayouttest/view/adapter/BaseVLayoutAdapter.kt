package com.example.vlayouttest.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter

abstract class BaseVLayoutAdapter<VH : RecyclerView.ViewHolder, T>(
    private val context: Context,
    private val layoutRes: Int
) : DelegateAdapter.Adapter<VH>() {
    private val mData = ArrayList<T>()

    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (mData.size > position) {
            onBindViewHolder(holder, mData[position], position)
        }
    }

    open fun onBindViewHolder(holder: VH, t: T, position: Int) {

    }

    protected fun getItemView(parent: ViewGroup): View {
        return LayoutInflater.from(context).inflate(layoutRes, parent, false)
    }

    fun setNewData(data: List<T>) {
        mData.clear()
        if (!data.isNullOrEmpty()) {
            mData.addAll(data)
        }
        notifyDataSetChanged()
    }

    fun addData(data: T) {
        val index = mData.size
        mData.add(data)
        notifyItemRangeChanged(index, 1)
    }

    fun addData(data: List<T>) {
        if (data.isNullOrEmpty()) return
        val index = mData.size
        addIndexData(index, data)
    }

    private fun addIndexData(index: Int, data: List<T>) {
        if (data.isNullOrEmpty()) return
        mData.addAll(data)
        notifyItemRangeChanged(index, data.size)
    }

}