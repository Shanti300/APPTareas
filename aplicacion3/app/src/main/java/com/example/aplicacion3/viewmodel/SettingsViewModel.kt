package com.example.aplicacion3.viewmodel

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacion3.data.AppPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application)

    private val _backgroundColor = MutableStateFlow(preferences.getBackgroundColor())
    val backgroundColor: StateFlow<Color> = _backgroundColor

    fun saveBackgroundColor(color: Color) {
        viewModelScope.launch {
            preferences.saveBackgroundColor(color)
            _backgroundColor.value = color  // 🔥 Actualiza el estado global
        }
    }
}
