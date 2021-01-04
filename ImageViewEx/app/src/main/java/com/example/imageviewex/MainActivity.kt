package com.example.imageviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_toast.setOnClickListner{
            Toast.makeText(this@MainActivity, "클릭클릭!", Toast.LENGTH_SHORT).show()

        }
    }
}