package com.adi.purnama.mymvvm.repository

import androidx.lifecycle.LiveData
import com.adi.purnama.mymvvm.data.local.daos.TodoListDao
import com.adi.purnama.mymvvm.data.local.entities.TodoList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Adi Purnama
 * @2019
 */
interface MainRepo {
    fun saveTodo(todo: TodoList)
    fun updateTodo(todo: TodoList)
    fun deleteTodo(todo: TodoList)
    fun getAllTodoList(): LiveData<List<TodoList>>
}

class MainRepoImpl(private val todoDao: TodoListDao) : MainRepo {

    override fun saveTodo(todo: TodoList) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                todoDao.saveTodo(todo)
            }
        }
    }

    override fun updateTodo(todo: TodoList) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                todoDao.updateTodo(todo)
            }
        }
    }

    override fun deleteTodo(todo: TodoList) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                todoDao.deleteTodo(todo)
            }
        }
    }

    override fun getAllTodoList(): LiveData<List<TodoList>> {
        return todoDao.getAllTodoList()
    }
}