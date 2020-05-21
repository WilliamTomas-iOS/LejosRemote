package com.example.lejosremote.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lejosremote.Data
import com.example.lejosremote.MyBluetoothAdapter

class MainViewModel(application: Application) : AndroidViewModel(application)  {

    private var data: Data

    private val _mac = MutableLiveData<String>()
    val mac: LiveData<String>
        get() = _mac

    private val _eventAdmin = MutableLiveData<Boolean>()
    val eventAdmin: LiveData<Boolean>
        get() = _eventAdmin

    private val _eventAuto = MutableLiveData<Boolean>()
    val eventAuto: LiveData<Boolean>
        get() = _eventAuto

    //var bt: MyBluetoothAdapter

    init {
        Log.i("MainViewModel", "GameVM created !")

        //bt = MyBluetoothAdapter()
        //bt.connect()


        data = Data(application.applicationContext)
        _mac.value = data.getMac()

        Log.i("MainViewModel", "adresse mac : " + mac)

        _eventAdmin.value = false
        _eventAuto.value = false
    }



    fun onUp() {
        Log.i("GameViewModel", "Up touched !")
        //bt.sendMsg(1)
        MyBluetoothAdapter.sendMsg(1)
    }

    fun onRight() {
        Log.i("GameViewModel", "Right touched !")
        //bt.sendMsg(2)
        MyBluetoothAdapter.sendMsg(2)
    }

    fun onLeft() {
        Log.i("GameViewModel", "Left touched !")
        //bt.sendMsg(3)
        MyBluetoothAdapter.sendMsg(3)
    }

    fun onDown() {
        Log.i("GameViewModel", "Down touched !")
        //bt.sendMsg(4)
        MyBluetoothAdapter.sendMsg(4)
    }

    fun onAuto() {
        Log.i("GameViewModel", "Auto touched !")
        //bt.sendMsg(5)
        MyBluetoothAdapter.sendMsg(5)
        _eventAuto.value = true
    }

    fun goAdmin() {
        Log.i("GameViewModel", "Admin touched !")
        _eventAdmin.value = true
    }

    fun onOff() {
        //bt.sendMsg(6)
        MyBluetoothAdapter.sendMsg(6)
    }

    fun klaxon() {
        //bt.sendMsg(7)
        MyBluetoothAdapter.sendMsg(7)
    }

    fun onNewMacAdress() {
        //bt.disconnect()
        //bt.connect()
    }
}
