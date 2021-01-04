package com.example.memolist

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var db : MemoDatabase
    var memoList = listOf<MemoEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MemoDatabase.getInstance(this)!!

        button_add.setOnClickListenr{
            val memo = MemoEntity(null, edittext_memo.text.toString())
            insertMemo(memo)
        }
    }

    // 1. Insert Data
    // 2. Get Data
    // 3. Delete Data

    // 4. Set RecyclerView

    fun insertMemo(memo : MemoEntity){
    // 1. MainTread vs WorkerThread(Background Thread)

        val insertTask = object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInbackground(vararg params: Unit?){
                db.memoDAO().insert(memo)
            }

            override fun onPostExecute(result : Unit?){
                super.onPostExecute(result)
                getAllMemos()
            }
        }
    }

    fun getAllMemo(){

    }

    fun deleteMemo(){

    }

    fun setRecyclerView(){

    }
}