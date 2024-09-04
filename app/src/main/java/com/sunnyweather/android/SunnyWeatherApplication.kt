package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication:Application {
    companion object {
        const val TOKEN = "UGezy5STyoVAszoP" // 填入你申请到的令牌值

        @SuppressLint("StaticFieldLeak")
        Lateinit
        var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}