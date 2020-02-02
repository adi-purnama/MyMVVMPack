package com.adi.purnama.mymvvm

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adi.purnama.mymvvm.data.local.entities.TodoList
import com.adi.purnama.mymvvm.di.testModule
import com.adi.purnama.mymvvm.repository.MainRepo
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by Adi Purnama
 * @2019
 */

class MainRepoTest:KoinTest {

    @Mock
    internal lateinit var context: Application
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setDb(){
        MockitoAnnotations.initMocks(this)
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(this@MainRepoTest.context)
            modules(listOf(testModule))
            androidFileProperties()
        }
    }
    @Test
    @Throws(Exception::class)
    fun checkRepo(){
        val mainRepo=mock(MainRepo::class.java)
        val spyMainRepo= spy(mainRepo)
        mock(TodoList::class.java)
        val testInput=TodoList(null,"test","Deskripsi","",0)
        verify(spyMainRepo).saveTodo(testInput)
        val test=mainRepo.getAllTodoList()
        test.observeForever { it.let {  } }
        //mainRepo.getAllTodoList()
    }

    @After
    fun after(){
        stopKoin()
    }
}