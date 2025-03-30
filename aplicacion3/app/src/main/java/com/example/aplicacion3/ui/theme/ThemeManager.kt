package com.example.aplicacion3.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.example.aplicacion3.data.AppPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object ThemeManager {
    // Definir pares de colores (fondo, botón) para los temas
    val lightTheme = Pair(Color(0xFFF5F5F5), Color(0xFF6200EE)) // Gris claro y morado
    val darkTheme = Pair(Color(0xFF121212), Color(0xFF03DAC5)) // Negro oscuro y teal
    val blueTheme = Pair(Color(0xFFE3F2FD), Color(0xFF2962FF)) // Azul claro y azul intenso
    val warmTheme = Pair(Color(0xFFFFF3E0), Color(0xFFFF6D00)) // Naranja claro y naranja intenso

    // Lista de temas disponibles
    private val themes = listOf(lightTheme, darkTheme, blueTheme, warmTheme)
    private var currentThemeIndex = 0

    // StateFlow para ser observado por todos los componentes
    private val _backgroundColor = MutableStateFlow(themes[0].first)
    val backgroundColor: StateFlow<Color> = _backgroundColor.asStateFlow()

    private val _buttonColor = MutableStateFlow(themes[0].second)
    val buttonColor: StateFlow<Color> = _buttonColor.asStateFlow()

    // Inicializar con el valor guardado en SharedPreferences
    fun initialize(appPreferences: AppPreferences) {
        currentThemeIndex = appPreferences.getThemeIndex()
        val theme = themes[currentThemeIndex]
        _backgroundColor.value = theme.first
        _buttonColor.value = theme.second
    }

    // Cambiar al siguiente tema
    fun cycleToNextTheme(appPreferences: AppPreferences) {
        currentThemeIndex = (currentThemeIndex + 1) % themes.size
        val theme = themes[currentThemeIndex]
        _backgroundColor.value = theme.first
        _buttonColor.value = theme.second
        appPreferences.saveThemeIndex(currentThemeIndex)
    }

    // Obtener el nombre del tema actual
    fun getCurrentThemeName(): String {
        return when (currentThemeIndex) {
            0 -> "Light Theme"
            1 -> "Dark Theme"
            2 -> "Blue Theme"
            3 -> "Warm Theme"
            else -> "Custom Theme"
        }
    }
}