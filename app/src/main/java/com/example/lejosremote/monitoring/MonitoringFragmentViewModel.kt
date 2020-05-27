package com.example.lejosremote.monitoring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lejosremote.DataFromEV3

class MonitoringFragmentViewModel : ViewModel() {

    private val _data = MutableLiveData<ByteArray>()
    val data: LiveData<ByteArray>
        get() = _data

    init {
        updateUIWithData()
    }

    fun updateUIWithData() {
        DataFromEV3.dataFromEV3.observeForever { elements ->
            if (elements != null) {
                _data.postValue(DataFromEV3.dataFromEV3.value)
            }
        }
    }
}
