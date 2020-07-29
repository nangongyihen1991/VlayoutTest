package com.example.vlayouttest.view.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.vlayouttest.view.bean.CommonBean

abstract class BaseCommonVLayoutAdapter<VH : RecyclerView.ViewHolder, T>(
    context: Context,
    layoutRes: Int
) : BaseVLayoutAdapter<VH, T>(context, layoutRes) {
    private var mAdapterData: CommonBean<*>? = null

    fun setAdapterData(data: CommonBean<*>) {
        this.mAdapterData = data
        data.data?.let {
            setNewData(it as List<T>)
        }
    }

    fun getAdapterData() = mAdapterData
}