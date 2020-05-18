package com.example.lejosremote.admin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lejosremote.Data

class AdminFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private var data: Data

    init {
        data = Data(application.applicationContext)
    }

    fun onLog() {

    }

    fun onMonitoring() {

    }

    fun onShutdown() {

    }

    fun onUpdateMac(mac: String) {
        data.setMac(mac)
    }

    fun onUpdatePassword(mdp: String) {
        data.setMdp(mdp)
    }
}
