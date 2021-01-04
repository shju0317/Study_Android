package com.example.memolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder

@Database(entities = arrayOf(MemoEntity::class), version = 1)
abstract class MemoDatabase {
    abstract fun memoDAO() : MemoDAO

    companion object{
        var INSTANCE : MemoDatabase? = null

        fun getInstance(context : Context){
            if(INSTANCE == null){
                synchronized(MemoDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MemoDatabase::class.java, "memo.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}