package com.example.mytestapplication.application

import android.app.Application
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner


class MyApplication : Application(),LifecycleObserver {
    override fun onCreate() {
        super.onCreate()
        MyApplication.context = applicationContext
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        //App in background
       // AppLogger.errorLogs("Appisin","bacground")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        // App in foreground
     //   AppLogger.errorLogs("Appisin","foreground")

    }

    companion object {
        lateinit  var context: Context

    }
}