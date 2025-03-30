package com.example.aplicacion3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacion3.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        // Puedes cargar las tareas iniciales aquí si tienes un sistema de persistencia
        // Por ejemplo: loadTasks()
    }

    fun addTask(description: String) {
        if (description.isNotBlank()) {
            val newTask = Task(title = description)  // Cambia description = description a title = description
            _tasks.value = _tasks.value + newTask
        }
    }

    fun updateTaskCompletion(task: Task, isCompleted: Boolean) {
        _tasks.value = _tasks.value.map {
            if (it == task) it.copy(isCompleted = isCompleted) else it
        }
    }

    // (Opcional)
    fun removeTask(task: Task) {
        _tasks.value = _tasks.value - task
    }

    // (Opcional) Cargar tareas desde un sistema de persistencia (por ejemplo, Room)
    // private fun loadTasks() {
    //     viewModelScope.launch {
    //         // Suponiendo que tienes un repositorio para acceder a los datos
    //         val loadedTasks = taskRepository.getAllTasks()
    //         _tasks.value = loadedTasks
    //     }
    // }
}