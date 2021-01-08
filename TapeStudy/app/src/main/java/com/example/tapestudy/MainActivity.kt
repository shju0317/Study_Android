package com.example.tapestudy

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TITLE_MIN_LENGTH = 5
    val TITLE_MAX_LENGTH = 20

    private val OPEN_GALLERY = 1
    private val OPEN_MUSIC = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val tapeSubjectArr: Array<String> = resources.getStringArray(R.array.tape_subject)

        val chipGroup:ChipGroup = findViewById(R.id.chip_group)

        for (subject in tapeSubjectArr){
            val chip:Chip = Chip(this) // Chip 인스턴스 생성
            chip.setText(subject) // Chip의 텍스트 지정
            chip.setTextColor(Color.WHITE)
            chip.chipBackgroundColor = ColorStateList.valueOf(Color.DKGRAY)
            chip.isCheckable = true

            chipGroup.addView(chip) // chipGroup에 chip 추가
        }

        val checkedChipId = chipGroup.checkedChipId // Will return View.NO_ID if singleSelection = false
        val checkedChipIds = chipGroup.checkedChipIds
            chipGroup.setOnCheckedChangeListener { group, checkedId ->
            // Handle child Chip checked/unchecked
        }

        // 제목 글자수 세기
        edit_title.addTextChangedListener(object: TextWatcher{

            var userinput = edit_title.text.toString()

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                lateinit var chkMsg:Unit
                if(userinput.length >= TITLE_MAX_LENGTH){
                    chkMsg = Toast.makeText(applicationContext,"20자 이하로 입력해주세요", Toast.LENGTH_LONG).show()
                }
//                else if(userinput.length < TITLE_MIN_LENGTH){
//                    chkMsg = Toast.makeText(applicationContext,"방송제목을 5자 이상 입력해주세요", Toast.LENGTH_SHORT).show()
//                }
            }

            override fun afterTextChanged(s: Editable?) {
                userinput = edit_title.text.toString()
                text_chkTitleLength.text = userinput.length.toString() + "/20"
            }
        })


        // Set chip group checked change listener
        chipGroup.setOnCheckedChangeListener{group, checkedId:Int ->
            // Get the checked chip instance from chip group
            val chip:Chip? = findViewById(checkedId)

//            if(chip != null ){
//                button_register.isEnabled = true
//                button_register.setBackgroundColor(Color.MAGENTA)
//            }

            chip?.let {
                //chip.chipBackgroundColor = ColorStateList.valueOf(Color.RED)

                var userinput = edit_title.text.toString()

                    //button_register.isEnabled = true
                    //button_register.setBackgroundColor(Color.MAGENTA)

            }
        }


        // 버튼 클릭에 따라 녹음화면 변환
        //button_record.setOnClickListener { chkVisibility() }
        changeLayoutVisibility()

        // 갤러리 열기
        button_openImg.setOnClickListener { openGallery() }

        // 음악폴더 열기
        button_upload.setOnClickListener { openMusic() }

        // 방송가이드 팝업창 띄우기
        button_guide.setOnClickListener{ showPopup() }

        // 테이프 등록
        button_register.setOnClickListener { registerTape() }
    }

    // 버튼 클릭에 따라 녹음화면 변환
    private fun changeLayoutVisibility(){
        View.OnClickListener {
            fun onClick(view: View?){
                when(view?.id){
                    R.id.button_record -> { layout_imageBtn1.setVisibility(View.INVISIBLE) }
                }
            }
        }
    }

    // 음악폴더 열기
    private fun openMusic(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("audio/*")
        startActivityForResult(intent, OPEN_MUSIC)
    }

    // 갤러리 열기
    private fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }


    // 방송가이드 팝업창 띄우기
    private fun showPopup(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_broadcast_guide, null)

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("방송가이드")
            .setNeutralButton("확인", null)
            .create()

        alertDialog.setView(view)
        alertDialog.window?.setGravity(Gravity.BOTTOM)
        alertDialog.show()
        //alertDialog.window.setLayout(500,400)
    }

    // 테이프 등록
    private fun registerTape(){
//       var chkMsg = Toast.makeText(this, "등록되었습니다!", Toast.LENGTH_SHORT)
//        chkMsg.show()
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_register_tape, null)

        val alertDialog = AlertDialog.Builder(this)
                .setNeutralButton("확인", null)
                .create()

        alertDialog.setView(view)
        alertDialog.show()
    }

    private fun chkRegisterBtn(){
//        // Set chip group checked change listener
//            chipGroup.setOnCheckedChangeListener{group, checkedId:Int ->
//                // Get the checked chip instance from chip group
//                val chip:Chip? = findViewById(checkedId)
//
//                chip?.let {
//                    chip.chipBackgroundColor = ColorStateList.valueOf(Color.RED)
//                }
//            }
    }

}