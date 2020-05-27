package com.example.lejosremote.monitoring

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lejosremote.DataFromEV3
import com.example.lejosremote.MyBluetoothAdapter
import kotlinx.coroutines.*

class MonitoringFragmentViewModel : ViewModel() {

//    private var viewModelJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _data = MutableLiveData<ByteArray>()
    val data: LiveData<ByteArray>
        get() = _data

    init {
        //_data.value = MyBluetoothAdapter.readMsg()
        updateUIWithData()
    }

    override fun onCleared() {
        super.onCleared()
//        viewModelJob.cancel()
    }

    fun updateUIWithData() {
//        MyBluetoothAdapter.isConnected.observeForever { connected ->
//            if (connected) {
//                Log.i("MonitoringFragmentVM", "Bien connecté à la brique")
//
//                uiScope.launch {
//                    while (true) {
//                        _data.postValue(MyBluetoothAdapter.readMsg())
//                        delay(100L)
//                    }
//                }
//            }
//        }
        DataFromEV3.dataFromEV3.observeForever { elements ->
            if (elements != null) {
                _data.postValue(DataFromEV3.dataFromEV3.value)
            }
        }
    }
}
