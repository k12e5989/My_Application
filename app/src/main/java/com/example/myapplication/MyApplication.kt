package com.example.myapplication

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, e ->
            e.printStackTrace()
        }
    }
}