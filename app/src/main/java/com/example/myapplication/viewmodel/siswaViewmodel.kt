package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class SiswaUIState(
    val nama: String = "",
    val gender: String = "",
    val alamat: String = ""
)

class SiswaViewModel : ViewModel() {
    private val _statusUI = MutableStateFlow(SiswaUIState())
    val statusUI: StateFlow<SiswaUIState> = _statusUI

    fun setSiswa(listDataSiswa: List<String>) {
        if (listDataSiswa.size >= 3) {
            _statusUI.value = SiswaUIState(
                nama = listDataSiswa[0],
                alamat = listDataSiswa[1],
                gender = listDataSiswa[2]
            )
        }
    }
}