package com.example.aplicacion3.data

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class AppPreferences(context: Context) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveBackgroundColor(color: Color) {
        sharedPreferences.edit {
            putInt("background_color", color.toArgb())
            apply() // Use apply() for asynchronous saving
        }
    }

    fun getBackgroundColor(): Color {
        val colorInt = sharedPreferences.getInt("background_color", Color.White.toArgb())
        return Color(colorInt)
    }

    // Guardar índice del tema seleccionado
    fun saveThemeIndex(index: Int) {
        sharedPreferences.edit {
            putInt("theme_index", index)
            apply()
        }
    }

    // Obtener índice del tema seleccionado (por defecto 0 - Light Theme)
    fun getThemeIndex(): Int {
        return sharedPreferences.getInt("theme_index", 0)
    }
}