package com.example.tapeuploadstudy.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity: AppCompatActivity(){

    abstract fun getLayoutResourceId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(this, getLayoutResourceId())

    }

    // R.id.content 영역에 들어갈 Fragment 생성
    protected fun findOrCreateFragment(){ }
}