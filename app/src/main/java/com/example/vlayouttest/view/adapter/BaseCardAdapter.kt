package com.example.vlayouttest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.example.vlayouttest.R
import com.example.vlayouttest.view.bean.CardBean

abstract class BaseCardAdapter<VH : RecyclerView.ViewHolder, T> : BaseVLayoutAdapter<VH, T> {
    private var mCardBean: CardBean<T>
    private var mCardViewHolder: BaseCardViewHolder? = null

    constructor(context: Context, item: CardBean<T>) : super(
        context,
        R.layout.view_card_item
    ) {
        mCardBean = item
        if (isSingleView()) {
            addData(getPlaceHolderItem())
        } else {
            addData(item.data!!)

        }
    }

    /**
     * 使用卡片或者列表为空使用单个view
     */
    private fun isSingleView() = useCardViewHolder() || mCardBean.data.isNullOrEmpty()

    /**
     * 空占位
     */
    abstract fun getPlaceHolderItem(): T

    abstract fun createCustomViewHolder(): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return if (useCardViewHolder()) {
            mCardViewHolder = BaseCardViewHolder(getItemView(parent))
            mCardViewHolder as VH
        } else {
            createCustomViewHolder()
        }
    }

    override fun onCreateLayoutHelper() = LinearLayoutHelper()

    fun onCreateCardLayoutHelper(): LayoutHelper? {
        return null
    }

    override fun onBindViewHolder(holder: VH, t: T, position: Int) {
        if (isSingleView()) {
            onBindSingleViewHolder(mCardBean)
        }
    }

    fun onBindSingleViewHolder(bean: CardBean<T>) {

    }

    private fun useCardViewHolder() = true

    open class BaseCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mViewCardTop: FrameLayout = itemView.findViewById(R.id.card_top)
        val mViewCardContent: FrameLayout = itemView.findViewById(R.id.card_content)
        val mViewCardBottom: FrameLayout = itemView.findViewById(R.id.card_bottom)

    }
}