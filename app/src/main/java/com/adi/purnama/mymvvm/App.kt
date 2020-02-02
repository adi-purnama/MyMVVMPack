package com.adi.purnama.mymvvm

import android.app.Application
import com.adi.purnama.mymvvm.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

/**
 * Created by Adi Purnama
 * @2019
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()

        //Initialising Koin
        startKoin {
            androidContext(this@App)
            modules(applicationModule)
            androidFileProperties()
        }
    }
}