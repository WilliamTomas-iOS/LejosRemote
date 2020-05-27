package com.example.lejosremote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

object DataFromEV3 {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _dataFromEV3 = MutableLiveData<ByteArray>()
    val dataFromEV3: LiveData<ByteArray>
        get() = _dataFromEV3

    fun getDataFromEV3() {
        uiScope.launch {
            while (true) {
                _dataFromEV3.postValue(MyBluetoothAdapter.readMsg())
                delay(100L)
            }
        }
    }
}