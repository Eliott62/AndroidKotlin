package com.example.androidkotlin

import android.os.Build.VERSION_CODES.O
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = O
    }

    fun onClickedIncrement(){
        counter.value = (counter.value ?: 0) + 1
    }
}
