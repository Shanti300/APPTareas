package com.example.aplicacion3.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.aplicacion3.R
import com.example.aplicacion3.data.AppPreferences
import com.example.aplicacion3.model.Task
import com.example.aplicacion3.ui.components.TaskItem
import com.example.aplicacion3.ui.theme.ThemeManager
import com.example.aplicacion3.viewmodel.TaskViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var viewModel: TaskViewModel
    private lateinit var appPreferences: AppPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        appPreferences = AppPreferences(requireContext())

        // Inicializar ThemeManager con las preferencias
        ThemeManager.initialize(appPreferences)

        val composeView = view.findViewById<ComposeView>(R.id.compose_content)
        composeView.setContent {
            val tasks by viewModel.tasks.collectAsState(initial = emptyList())
            val backgroundColor by ThemeManager.backgroundColor.collectAsState()

            LazyColumn(
                modifier = Modifier.background(backgroundColor)
            ) {
                items(tasks) { task ->
                    TaskItem(task = task, onTaskCompletionChange = { isChecked ->
                        viewModel.updateTaskCompletion(task, isChecked)
                    })
                }
            }
        }

        val navController = findNavController()

        // Referencias a botones
        val btnGoToDetails = view.findViewById<Button>(R.id.button_go_to_details)
        val btnSettings = view.findViewById<Button>(R.id.button_settings)
        val btnAddTask = view.findViewById<Button>(R.id.button_add_task)
        val editTextNewTask = view.findViewById<EditText>(R.id.edit_text_new_task)

        // Configurar listeners de botones
        btnGoToDetails.setOnClickListener {
            navController.navigate(R.id.detailsFragment)
        }

        btnSettings.setOnClickListener {
            navController.navigate(R.id.settingsFragment)
        }

        btnAddTask.setOnClickListener {
            val taskText = editTextNewTask.text.toString()
            if (taskText.isNotBlank()) {
                viewModel.addTask(taskText)
                editTextNewTask.text.clear()
            }
        }

        // Observar cambios en los colores
        viewLifecycleOwner.lifecycleScope.launch {
            ThemeManager.backgroundColor.collect { color ->
                // Aplicar color de fondo al contenedor principal si es necesario
                view.setBackgroundColor(color.toArgb())
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            ThemeManager.buttonColor.collect { color ->
                // Aplicar color a los botones
                val buttonColor = color.toArgb()
                btnGoToDetails.setBackgroundColor(buttonColor)
                btnSettings.setBackgroundColor(buttonColor)
                btnAddTask.setBackgroundColor(buttonColor)
            }
        }

        return view
    }
}