package com.example.lejosremote.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.lejosremote.Data
import com.example.lejosremote.MyBluetoothAdapter
import kotlinx.coroutines.*

abstract class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var data: Data

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _mac = MutableLiveData<String>()
    val mac: LiveData<String>
        get() = _mac

    private val _eventAdmin = MutableLiveData<Boolean>()
    val eventAdmin: LiveData<Boolean>
        get() = _eventAdmin

    private val _eventAuto = MutableLiveData<Boolean>()
    val eventAuto: LiveData<Boolean>
        get() = _eventAuto

    private val _dataInterface = MutableLiveData<ByteArray>()
    val dataInterface: LiveData<ByteArray>
        get() = _dataInterface

    init {
        Log.i("MainViewModel", "GameVM created !")

        data = Data(application.applicationContext)
        _mac.value = data.getMac()

        Log.i("MainViewModel", "adresse mac : " + mac)

        _eventAdmin.value = false
        _eventAuto.value = false

        //updateUIWithData()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onUp() {
        Log.i("GameViewModel", "Up touched !")
        //MyBluetoothAdapter.sendMsg(1)
    }

    fun onRight() {
        Log.i("GameViewModel", "Right touched !")
        //MyBluetoothAdapter.sendMsg(2)
    }

    fun onLeft() {
        Log.i("GameViewModel", "Left touched !")
        //MyBluetoothAdapter.sendMsg(3)
    }

    fun onDown() {
        Log.i("GameViewModel", "Down touched !")
        //MyBluetoothAdapter.sendMsg(4)
    }

    fun onAuto() {
        Log.i("GameViewModel", "Auto touched !")
        //MyBluetoothAdapter.sendMsg(5)
        _eventAuto.value = true
    }

    fun goAdmin() {
        Log.i("GameViewModel", "Admin touched !")
        _eventAdmin.value = true
    }

    fun onOff() {
        //MyBluetoothAdapter.sendMsg(6)
    }

    fun klaxon() {
        //MyBluetoothAdapter.sendMsg(7)
    }

    fun onNewMacAdress() {
        //MyBluetoothAdapter.connect()
    }

    fun onPlus() {
        //MyBluetoothAdapter.sendMsg(8)
    }

    fun onMoins() {
        //MyBluetoothAdapter.sendMsg(9)
    }

    fun updateUIWithData() {
        MyBluetoothAdapter.isConnected.observeForever { connected ->
            if (connected) {
//                GlobalScope.launch {
//                    while (true) {
//                        _dataInterface.postValue(MyBluetoothAdapter.readMsg())
//                        delay(1000L)
//                    }
//                }
                Log.i("MainViewModel", "Bien connecté à la brique")

                uiScope.launch {
                    while (true) {
                        _dataInterface.postValue(MyBluetoothAdapter.readMsg())
                        delay(1000L)
                    }
                }
            }
        }
    }
}
