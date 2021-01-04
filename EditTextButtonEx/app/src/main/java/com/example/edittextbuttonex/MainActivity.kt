package com.example.edittextbuttonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티가 최초 실행되면 이곳을 수행한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_getText.setOnClickListener { // EditText에 입력되어있는 값을 가져와서 TextView에 뿌려준다.
            var resultText = et_id.text.toString()
            tv_result.setText(resultText)
        }
    }
}