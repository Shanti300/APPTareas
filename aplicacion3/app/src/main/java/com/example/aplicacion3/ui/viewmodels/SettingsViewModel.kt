package com.example.aplicacion3.ui.viewmodels

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacion3.data.AppPreferences
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application)

    fun saveBackgroundColor(color: Color) {
        viewModelScope.launch {
            preferences.saveBackgroundColor(color)
        }
    }

    // Función para obtener el color actual de las preferencias
    fun getCurrentBackgroundColor(): Color {
        return preferences.getBackgroundColor()
    }
}