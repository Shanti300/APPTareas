package com.example.aplicacion3.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.aplicacion3.model.Task
import com.example.aplicacion3.ui.theme.ThemeManager

@Composable
fun TaskItem(task: Task, onTaskCompletionChange: (Boolean) -> Unit) {
    val buttonColor by ThemeManager.buttonColor.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { isChecked ->
                onTaskCompletionChange(isChecked)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = buttonColor,
                uncheckedColor = buttonColor.copy(alpha = 0.6f)
            )
        )

        Text(
            text = task.title,
            modifier = Modifier.padding(start = 8.dp),
            textDecoration = if (task.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
            color = if (task.isCompleted) Color.Gray else Color.Black
        )
    }
}