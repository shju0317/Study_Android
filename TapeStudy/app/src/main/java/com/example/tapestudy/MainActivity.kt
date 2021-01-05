package com.example.tapestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    // 파일명 글자 수 제한
    val TITLE_MIN_LENGTH = 5
    val TITLE_MAX_LENGTH = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val tapeSubjectArr: Array<String> = resources.getStringArray(R.array.tape_subject)

        val chipGroup:ChipGroup = findViewById(R.id.chip_group)

        for (subject in tapeSubjectArr){
            val chip:Chip = Chip(this) // Chip 인스턴스 생성
            chip.setText(subject) // Chip의 텍스트 지정

//            chipGroup.setOnCheckedChangeListener{_, isChecked ->
//                if (isChecked){
//                    chip.setBackgroundColor()
//                }
//            }

            chipGroup.addView(chip)
        }

        chipGroup.isSingleSelection = true

        val checkedChipId = chipGroup.checkedChipId


    }
}