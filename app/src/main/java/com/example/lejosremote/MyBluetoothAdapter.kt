package com.example.lejosremote

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.util.Log
import java.io.OutputStreamWriter
import java.lang.Exception
import java.util.*

object MyBluetoothAdapter: Application() {
//    private object HOLDER {
//        val INSTANCE = MyBluetoothAdapter()
//    }
//
//    companion object {
//        val INSTANCE: MyBluetoothAdapter by lazy { HOLDER.INSTANCE }
//    }

    private var bAdapter: BluetoothAdapter
    private lateinit var socket: BluetoothSocket
    private lateinit var device: BluetoothDevice
    private lateinit var output: OutputStreamWriter

    //var context: Context

    lateinit var contextGlobal: Context

    lateinit var data: Data

    init {
        bAdapter = BluetoothAdapter.getDefaultAdapter()
        if(bAdapter == null) {
            Log.i("Init bAdapter", "adapter non dispo")
        } else {
            if(!bAdapter.isEnabled)
                bAdapter.enable()
                Log.i("Init bAdapter", "adapter démarré")
        }
        //context = applicationContext
        //data = Data(context)

        Log.i("MyBluetoothAdapter", "adresse mac reçues" + data.getMac())

        //connect()
    }

    fun setGlobalContext(ctx: Context) {
        contextGlobal = ctx
    }

    fun connect() {
        data = Data(contextGlobal)

        device = bAdapter.getRemoteDevice(data.getMac())

        try {
            socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
            socket.connect()
            Log.i("Connect bAdapter", "connexion à la brique réussi")
        } catch (e: Exception) {
            Log.i("Connect bAdapter", "erreur de connexion à la brique")
        }
    }

    fun disconnect() {
        output.close()
        socket.close()
        Log.i("Disonnect bAdapter", "déconnexion réussi")
    }

    fun sendMsg(msg: Int) {
        try {
            output = OutputStreamWriter(socket.outputStream)
            output.write(msg)
            output.flush()
        } catch (e: Exception) {
            Log.i("Send msg", "erreur envoie du message")
        }
    }
}