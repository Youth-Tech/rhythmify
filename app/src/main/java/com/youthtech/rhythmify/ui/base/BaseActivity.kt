package com.youthtech.rhythmify.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(private val bindingFactory: (LayoutInflater) -> B) :
    AppCompatActivity() {

    protected val binding: B by lazy {
        bindingFactory(layoutInflater)
    }
    protected val TAG: String = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
        addListener()
    }

    abstract fun init()
    abstract fun addListener()
}