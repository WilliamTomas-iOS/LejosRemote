package com.example.lejosremote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        MyBluetoothAdapter.setGlobalContext(this)
        MyBluetoothAdapter.connect()

        MyBluetoothAdapter.isConnected.observeForever { connected ->
            if (connected) {
                DataFromEV3.getDataFromEV3()
            }
        }
    }
}
