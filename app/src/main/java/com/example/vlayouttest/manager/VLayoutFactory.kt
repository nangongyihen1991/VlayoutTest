@file:Suppress("UNCHECKED_CAST")

package com.example.vlayouttest.manager

import android.content.Context
import com.example.vlayouttest.view.adapter.BaseVLayoutAdapter

object VLayoutFactory {
    private val mMap = HashMap<Int, String>()

    fun <T> register(type: Int, clazz: Class<T>) {
        mMap[type] = clazz.name
    }

    fun <T : BaseVLayoutAdapter<*, *>> getAdapter(context: Context, type: Int): T? {
        val name = mMap[type]
        return if (name.isNullOrEmpty()) {
            null
        } else {
            Class.forName(name)
                ?.getConstructor(Context::class.java)
                ?.newInstance(context) as? T
        }
    }
}