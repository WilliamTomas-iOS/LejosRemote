package com.example.lejosremote.monitoring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lejosremote.MyBluetoothAdapter

class MonitoringFragmentViewModel : ViewModel() {

    private val _data = MutableLiveData<ByteArray>()
    val data: LiveData<ByteArray>
        get() = data

    init {
        _data.value = MyBluetoothAdapter.readMsg()
    }
}
