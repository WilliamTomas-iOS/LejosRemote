package com.example.lejosremote

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.preference.PreferenceManager

class Data(context: Context) : Application() {

    public lateinit var mPreferences: SharedPreferences
    public lateinit var mEditor: SharedPreferences.Editor

    init {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        mEditor = mPreferences.edit()

    }

    public fun getMac(): String {
        val ev3Mac = mPreferences.getString("mac", "00:16:53:80:46:CC")
        Log.i("Data", "mac en mémoire" + ev3Mac.toString())
        return ev3Mac.toString()
    }

    public fun getMdp(): String {
        val mdp = mPreferences.getString("mdp", "admin")
        return mdp.toString()
    }

    public fun setMac(mac: String) {
        Log.i("Data", "mac reçu" + mac)
        mEditor.putString("mac", mac)
        mEditor.commit()
    }

    public fun setMdp(mdp: String) {
        Log.i("Data", "mdp reçu" + mdp)
        mEditor.putString("mdp", mdp)
        mEditor.commit()
    }
}