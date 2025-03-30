package com.example.aplicacion3.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.toArgb
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.aplicacion3.data.AppPreferences
import com.example.aplicacion3.databinding.FragmentDetailsBinding
import com.example.aplicacion3.ui.theme.ThemeManager
import com.example.aplicacion3.ui.viewmodels.DetailsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsScreen : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var appPreferences: AppPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        appPreferences = AppPreferences(requireContext())
        ThemeManager.initialize(appPreferences)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.detailsText.observe(viewLifecycleOwner, Observer { text ->
            binding.textViewDetails.text = text
        })

        binding.buttonUpdate.setOnClickListener {
            viewModel.updateDetails("Lo ves, la información que viste fue actualizada :D")
        }

        // Observar cambios en el color de fondo
        viewLifecycleOwner.lifecycleScope.launch {
            ThemeManager.backgroundColor.collect { color ->
                binding.detailsContainer.setBackgroundColor(color.toArgb())
            }
        }

        // Observar cambios en el color de los botones
        viewLifecycleOwner.lifecycleScope.launch {
            ThemeManager.buttonColor.collect { color ->
                binding.buttonUpdate.setBackgroundColor(color.toArgb())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}