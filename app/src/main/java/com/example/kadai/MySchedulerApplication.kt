package com.example.kadai

import android.app.Application
import android.hardware.SensorManager
import android.hardware.SensorManager.getOrientation
import androidx.recyclerview.widget.DividerItemDecoration
import io.realm.Realm
import io.realm.RealmConfiguration

class MySchedulerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true).build()
        Realm.setDefaultConfiguration(config)
       //DividerItemDecoration decorator = new DividerItemDecoration(recycler.getContext(), layout.getOrientation())
    }
}