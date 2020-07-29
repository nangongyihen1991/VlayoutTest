package com.example.vlayouttest

import android.app.Application
import com.example.vlayouttest.manager.Constants
import com.example.vlayouttest.manager.VLayoutFactory
import com.example.vlayouttest.view.adapter.*

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        VLayoutFactory.register(Constants.TYPE_LINEAR, LinearAdapter::class.java)
        VLayoutFactory.register(Constants.TYPE_GRID, GridAdapter::class.java)
        VLayoutFactory.register(Constants.TYPE_STICKY, StickyAdapter::class.java)
        VLayoutFactory.register(Constants.TYPE_FLOAT, FloatAdapter::class.java)
        VLayoutFactory.register(Constants.TYPE_FIX, FixAdapter::class.java)
    }
}