package com.adi.purnama.mymvvm.di

import androidx.room.Room
import com.adi.purnama.mymvvm.data.local.AppDatabase
import com.adi.purnama.mymvvm.repository.MainRepo
import com.adi.purnama.mymvvm.repository.MainRepoImpl
import com.adi.purnama.mymvvm.ui.main.MainVm
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Adi Purnama
 * @2019
 */

val testModule= module{

    // Room database
    single {
        Room.inMemoryDatabaseBuilder(
            androidApplication(), AppDatabase::class.java).allowMainThreadQueries().build()
    }
    // Daos
    single { get<AppDatabase>().todoListDao() }

    //Repository
    factory<MainRepo> { MainRepoImpl(get()) }

    //ViewModel
    viewModel { MainVm(get()) }
}