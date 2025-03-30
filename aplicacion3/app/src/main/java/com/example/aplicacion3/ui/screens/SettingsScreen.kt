package com.example.aplicacion3.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacion3.data.AppPreferences
import com.example.aplicacion3.ui.theme.ThemeManager
import com.example.aplicacion3.viewmodel.SettingsViewModel

class SettingsScreen : Fragment() {

    private lateinit var viewModel: SettingsViewModel
    private lateinit var appPreferences: AppPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        appPreferences = AppPreferences(requireContext())

        return ComposeView(requireContext()).apply {
            setContent {
                SettingsScreenContent()
            }
        }
    }

    @Composable
    fun SettingsScreenContent() {
        val backgroundColor by ThemeManager.backgroundColor.collectAsState()
        val buttonColor by ThemeManager.buttonColor.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ajustes de color",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tu tema actual: ${ThemeManager.getCurrentThemeName()}",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Cambiar al siguiente tema
                    ThemeManager.cycleToNextTheme(appPreferences)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                )
            ) {
                Text("Cambiar de tema")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Estos cambios se aplicaran en la aplicación de forma global.",
                fontSize = 14.sp
            )
        }
    }
}