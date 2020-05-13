package com.example.lejosremote.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.lejosremote.MyBluetoothAdapter

class MainViewModel : ViewModel() {
    var bt: MyBluetoothAdapter

    init {
        Log.i("MainViewModel", "GameVM created !")
        bt = MyBluetoothAdapter()
        bt.connect()
    }

    fun onUp() {
        Log.i("GameViewModel", "Up touched !")
        bt.sendMsg(1)
    }

    fun onRight() {
        Log.i("GameViewModel", "Right touched !")
        bt.sendMsg(2)
    }

    fun onLeft() {
        Log.i("GameViewModel", "Left touched !")
        bt.sendMsg(3)
    }

    fun onDown() {
        Log.i("GameViewModel", "Down touched !")
        bt.sendMsg(4)
    }

    fun onAuto() {
        Log.i("GameViewModel", "Auto touched !")
        bt.sendMsg(5)
    }

    fun goAdmin() {
        Log.i("GameViewModel", "Admin touched !")
        bt.sendMsg(6)
    }
}
