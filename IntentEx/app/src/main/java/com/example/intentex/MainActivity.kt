package com.example.intentex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main

        btn_a.setOnClickListener{
            // var: 값이 언제든지 변경될 수 있는 변수
            // val: 자바에서는 final값이 변경되지 못하는 변수
            val intent = Intent(this, SubActivity::class.java) // 화면 이동을 위한 인텐트 객체 생성
            intent.putExtra("msg",tv_sendMsg.text.toString())
            startActivity(intent) // intent에 저장되어 있는 액테비티로 이동
            finish() // 자기 자신 액티비티 종료
        }
    }
}