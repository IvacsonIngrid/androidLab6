package com.example.androidnavigationexample

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidnavigationexample.model.Question



class MainViewModel : ViewModel() {
    var list: MutableList<Question> = generateDummyList(50).toMutableList()
    var currentPosition: Int = 0

    init {
        Log.d("xxx", "MainViewModel constructor")
    }

    fun addItem(item: Question) {
        list.add(item)
    }

    fun getItem(): Question {
        return list[currentPosition]
    }

    fun generateDummyList(size: Int): List<Question>{
        Log.d("xxx", "generateDummyList")
        val list = ArrayList<Question>()
        for (i in 0 until size ){

            val item = Question(getItem().text, getItem().answers)
            list += item
        }
        return list
    }
}
