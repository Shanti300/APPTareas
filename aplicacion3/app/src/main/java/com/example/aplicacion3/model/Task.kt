package com.example.aplicacion3.model

data class Task(
    val id: Int? = null,
    val title: String,  // Cambia description a title
    val isCompleted: Boolean = false
)