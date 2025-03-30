package com.example.aplicacion3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplicacion3.R
import com.example.aplicacion3.ui.components.TaskItem
import com.example.aplicacion3.model.Task
import com.example.aplicacion3.viewmodel.TaskViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    var newTaskText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título (opcional)
        Text(
            text = stringResource(R.string.home_screen_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de tareas
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                TaskItem(task = task, onTaskCompletionChange = { isChecked ->
                    viewModel.updateTaskCompletion(task, isChecked)
                })
            }
        }

        // Campo de texto para nueva tarea
        OutlinedTextField(
            value = newTaskText,
            onValueChange = { newTaskText = it },
            label = { Text("New Task") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para agregar tarea
        Button(
            onClick = {
                if (newTaskText.isNotBlank()) {
                    viewModel.addTask(newTaskText)
                    newTaskText = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para ir a detalles
        Button(onClick = { navController.navigate("details") }) {
            Text(stringResource(R.string.go_to_details))  // Usa el recurso de cadena
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para ir a configuración
        Button(onClick = { navController.navigate("settings") }) {
            Text(stringResource(R.string.settings_screen_title))
        }
    }
}