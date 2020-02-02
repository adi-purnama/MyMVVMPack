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
val applicationModule=module{

    //Migration Database if need
    /*val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                    "PRIMARY KEY(`id`))")
        }
    }*/

    // Room database
    single {
        Room.databaseBuilder(androidApplication(),
            AppDatabase::class.java,"MY_TODO_DB")
            //.addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .fallbackToDestructiveMigration()
            .build()
    }
    // Daos
    single { get<AppDatabase>().todoListDao() }

    //Repository
    factory<MainRepo> { MainRepoImpl(get()) }

    //ViewModel
    viewModel { MainVm(get()) }
}