package com.adi.purnama.mymvvm.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.adi.purnama.mymvvm.data.local.entities.TodoList

/**
 * Created by Adi Purnama
 * @2019
 */

@Dao
interface TodoListDao {

    @Insert
    suspend fun saveTodo(todoRecord: TodoList)

    @Delete
    suspend fun deleteTodo(todoRecord: TodoList)

    @Update
    suspend fun updateTodo(todoRecord: TodoList)

    @Query("SELECT * FROM todo_list ORDER BY id DESC")
    fun getAllTodoList(): LiveData<List<TodoList>>
}