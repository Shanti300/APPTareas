package com.example.aplicacion3.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {

    private val _detailsText = MutableLiveData("ACERCA DE\n\nTareasYA es una aplicación en fase de desarrollo que te permite gestionar tus tareas de manera eficiente y en la que puedes ir tachando las que ya hiciste. Esta aplicación fue hecha por Santiago Gonzalez el dia 29 de marzo de 2025. \nTodos los derechos reservados.\n\nPara demostrate que esta pantalla usa un ViewModel y un LiveData, puedes presionar el boton para ver como cambia la pantalla")
    val detailsText: LiveData<String> = _detailsText

    fun updateDetails(newText: String) {
        _detailsText.value = newText
    }
}
