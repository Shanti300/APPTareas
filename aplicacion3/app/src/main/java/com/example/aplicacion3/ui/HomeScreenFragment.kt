package com.example.aplicacion3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.aplicacion3.R
import com.example.aplicacion3.databinding.FragmentHomeBinding
import com.example.aplicacion3.model.Task
import com.example.aplicacion3.ui.components.TaskItem  // Asegúrate de importar TaskItem
import com.example.aplicacion3.viewmodel.TaskViewModel

class HomeScreenFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        binding.composeContent.setContent {
            val viewModel: TaskViewModel = viewModel()
            HomeScreenCompose(viewModel = viewModel)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// Nuevo Composable para el contenido de la lista de tareas
@Composable
fun HomeScreenCompose(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()
    var newTaskText by remember { mutableStateOf("") }

    androidx.compose.foundation.layout.Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                TaskItem(task = task, onTaskCompletionChange = { isChecked ->
                    viewModel.updateTaskCompletion(task, isChecked)
                })
            }
        }
    }
}