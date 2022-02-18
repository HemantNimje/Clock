package com.hemant.clock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ClockViewModel: ViewModel() {

    // current clock time in milliseconds
    private val clockMutableLiveData = MutableLiveData<Long>()

    init {
        calculateAndEmitCurrentSystemTime()
    }

    private fun calculateAndEmitCurrentSystemTime() {

        viewModelScope.launch {
            while (true) {
                val currentTime = System.currentTimeMillis()
                clockMutableLiveData.postValue(currentTime)
                delay(1000)
            }
        }
    }

    fun getClockLiveData(): LiveData<Long> = clockMutableLiveData
}