package com.example.vlayouttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.example.vlayouttest.manager.Constants
import com.example.vlayouttest.manager.VLayoutFactory
import com.example.vlayouttest.view.adapter.BaseCommonVLayoutAdapter
import com.example.vlayouttest.view.bean.CommonBean
import com.example.vlayouttest.view.bean.TestBean
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mAdapter: DelegateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        updateView()
    }

    private fun initView() {
        val layoutManager = VirtualLayoutManager(this)
        mRv.layoutManager = layoutManager
        mAdapter = DelegateAdapter(layoutManager, true)
        mRv.adapter = mAdapter
        val viewPool = RecycledViewPool()
        mRv.setRecycledViewPool(viewPool)
        viewPool.setMaxRecycledViews(Constants.TYPE_LINEAR, 10)
    }

    private fun updateView() {
        getData().map { bean ->
            VLayoutFactory.getAdapter<BaseCommonVLayoutAdapter<*, *>>(
                this@MainActivity,
                bean.type
            )?.also { it.setAdapterData(bean) }
        }.let {
            mAdapter?.setAdapters(it)
        }
    }

    private fun getData(): List<CommonBean<*>> {
        val data = ArrayList<CommonBean<*>>()
        val testData = Array<Int>(20) { it }
        data.add(
            CommonBean(
                Constants.TYPE_LINEAR,
                testData.map { it -> TestBean("TYPE_LINEAR： $it") })
        )
        data.add(CommonBean(Constants.TYPE_GRID, testData.map { it -> TestBean("TYPE_GRID： $it") }))
        data.add(CommonBean<Unit>(Constants.TYPE_STICKY))
        data.add(CommonBean<Unit>(Constants.TYPE_FLOAT))
        data.add(CommonBean<Unit>(Constants.TYPE_FIX))
        data.add(
            CommonBean(
                Constants.TYPE_LINEAR,
                testData.map { it -> TestBean("TYPE_LINEAR： $it") })
        )
        return data
    }
}