package com.adi.purnama.mymvvm

import android.app.Application
import com.adi.purnama.mymvvm.di.applicationModule
import org.junit.After
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Adi Purnama
 * @2019
 */
class KoinModuleTest : KoinTest {
    @Mock
    internal lateinit var context: Application

    @Test
    fun `checking modules`() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(this@KoinModuleTest.context).modules(listOf(applicationModule))
        }.checkModules()
        //Mockito.mock(HomeVM::class.java)
    }

    @After
    fun after(){
        stopKoin()
    }
}