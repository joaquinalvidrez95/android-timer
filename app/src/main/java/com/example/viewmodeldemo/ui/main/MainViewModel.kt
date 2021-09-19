package com.example.viewmodeldemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _timer = MutableLiveData(0)
    val timer: LiveData<Int>
        get() = _timer

    fun increaseTimer() {
        _timer.value = _timer.value?.plus(1)
    }
}