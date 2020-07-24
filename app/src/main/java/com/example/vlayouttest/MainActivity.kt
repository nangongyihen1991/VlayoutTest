package com.example.vlayouttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.example.vlayouttest.manager.Constants
import com.example.vlayouttest.view.adapter.*
import com.example.vlayouttest.view.bean.CardBean
import com.example.vlayouttest.view.bean.VLayoutBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mAdatper: DelegateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
//        mAdatper?.addAdapter(getLinearAdapter())
//        mAdatper?.addAdapter(getGridAdapter())
//        mAdatper?.addAdapter(getStickyAdapter())
//        mAdatper?.addAdapter(getLinearAdapter())
//        mAdatper?.addAdapter(getFloatAdapter())
//        mAdatper?.addAdapter(getFixAdapter())
        updateView()
    }

    private fun initView() {
        val layoutManager = VirtualLayoutManager(this)
        mRv.layoutManager = layoutManager
        mAdatper = DelegateAdapter(layoutManager, true)
        mRv.adapter = mAdatper
    }

    private fun updateView() {
        val data = ArrayList<CardBean>()
        val cardBean = CardBean()
        cardBean.type = Constants.TYPE_LINEAR
        cardBean.data = ArrayList<String>().also {
            for (i in 0..10) {
                it.add("cardBean $i")
            }
        }
        data.add(cardBean)
    }

    private fun getLinearAdapter(): LinearAdapter {
        val data = ArrayList<VLayoutBean>()
        for (i in 0..20) {
            data.add(VLayoutBean("LinearAdapter:$i"))
        }
        return LinearAdapter(this).also { it.setNewData(data) }
    }


    private fun getGridAdapter(): GridAdapter {
        val data = ArrayList<VLayoutBean>()
        for (i in 0..6) {
            data.add(VLayoutBean("GridAdapter:$i"))
        }
        return GridAdapter(this).also { it.setNewData(data) }
    }

    private fun getFloatAdapter(): FloatAdapter {
        val data = ArrayList<VLayoutBean>()
        data.add(VLayoutBean("FloatAdapter"))
        return FloatAdapter(this).also { it.setNewData(data) }
    }

    private fun getFixAdapter(): FixAdapter {
        val data = ArrayList<VLayoutBean>()
        data.add(VLayoutBean("FixAdapter"))
        return FixAdapter(this).also { it.setNewData(data) }
    }

    private fun getStickyAdapter(): StickyAdapter {
        val data = ArrayList<VLayoutBean>()
        data.add(VLayoutBean("--------StickyAdapter-----"))
        return StickyAdapter(this).also { it.setNewData(data) }
    }
}