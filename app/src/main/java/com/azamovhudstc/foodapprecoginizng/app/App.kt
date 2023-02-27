package com.azamovhudstc.foodapprecoginizng.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
@HiltAndroidApp

class App :Application (){
    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
    }

}