package com.example.viewmodeldemo.ui.main

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _timer = MutableLiveData(0)
    val timer: LiveData<Int>
        get() = _timer
    private val cdTimer = object : CountDownTimer(10000, 1000) {
        override fun onTick(p0: Long) {
            _timer.value = _timer.value?.plus(1)
        }

        override fun onFinish() {
            _timer.value = 0
        }

    }
    private var isRunning = false

    fun increaseTimer() {
    }

    fun pause() {
        TODO("Not yet implemented")
    }

    fun stop() {
        cdTimer.cancel()
    }

    fun start() {
        if (!isRunning) {
            cdTimer.start()
        }
        isRunning = true
    }
}