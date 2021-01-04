package com.example.intentex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        
        if(intent.hasExtra("msg")){
            tv_getMsg.text = intent.getStringExtra("msg") // 서브 액티비티에 존재하는 텍스트뷰에다가 String이 넘겨져 옴
        }
    }
}