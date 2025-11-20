package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class SiswaUIState(
    val nama: String = "",
    val gender: String = "",
    val alamat: String = ""
)

