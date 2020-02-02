package com.adi.purnama.mymvvm.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adi.purnama.mymvvm.data.local.entities.TodoList
import com.adi.purnama.mymvvm.repository.MainRepo

/**
 * Created by Adi Purnama
 * @2019
 */

class MainVm(private val todoRepo: MainRepo): ViewModel() {

    fun saveTodo(todo: TodoList) {
        todoRepo.saveTodo(todo)
    }

    fun updateTodo(todo: TodoList){
        todoRepo.updateTodo(todo)
    }

    fun deleteTodo(todo: TodoList) {
        todoRepo.deleteTodo(todo)
    }

    fun getAllTodoList(): LiveData<List<TodoList>> {
        return todoRepo.getAllTodoList()
    }
}