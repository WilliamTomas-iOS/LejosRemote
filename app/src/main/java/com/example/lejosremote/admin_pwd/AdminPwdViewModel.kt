package com.example.lejosremote.admin_pwd

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lejosremote.Data

class AdminPwdViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var mdp: String

    private val _eventMdpOk = MutableLiveData<Boolean>()
    val eventMdpOk: LiveData<Boolean>
        get() = _eventMdpOk

    init {
        _eventMdpOk.value = false
        mdp = Data(application.applicationContext).getMdp()
    }

    fun update(password: String) {
        Log.i("AdminPwdViewModel", "message reçu " + password)
        if(password == mdp) {
            _eventMdpOk.value = true
        }
    }
}
