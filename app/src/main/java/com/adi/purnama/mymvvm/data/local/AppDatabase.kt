package com.adi.purnama.mymvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adi.purnama.mymvvm.data.local.daos.TodoListDao
import com.adi.purnama.mymvvm.data.local.entities.TodoList

/**
 * Created by Adi Purnama
 * @2019
 */
@Database(entities = [TodoList::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoListDao(): TodoListDao
}
