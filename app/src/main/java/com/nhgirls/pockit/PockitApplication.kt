package com.nhgirls.pockit

import android.app.Application

class PockitApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalApp = this
    }

    companion object {
        lateinit var GlobalApp : PockitApplication
    }
}