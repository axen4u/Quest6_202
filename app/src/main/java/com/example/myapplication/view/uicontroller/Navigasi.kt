package com.example.myapplication.uicontroller // Menggunakan myapplication

// Imports Compose dan Material
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

// Imports ViewModel dan State
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

// Imports Navigasi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Imports File Lokal Anda (Menggunakan myapplication dan Model.DataJK)
import com.example.myapplication.Model.DataJK.Jenisk
import com.example.myapplication.view.FormSiswa
import com.example.myapplication.view.TampilSiswa
import com.example.myapplication.viewmodel.SiswaViewModel

// Enum Navigasi
enum class Navigasi {
    Formulir,
    Detail
}

// Fungsi Pembantu Navigasi
private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(route = Navigasi.Formulir.name, inclusive = false)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // PERBAIKAN: Menggunakan collectAsState() tanpa argumen 'initial ='
    val uiState by viewModel.statusUI.collectAsState()

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = modifier.padding(isiRuang)
        ) {
            // Rute Formulir
            composable(route = Navigasi.Formulir.name) {
                val konteks = LocalContext.current

                FormSiswa(
                    pilihanJK = Jenisk.map { id -> konteks.resources.getString(id) },
                    onSubmitButtonClicked = { listDataSiswa ->
                        viewModel.setSiswa(listDataSiswa)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            // Rute Detail
            composable(route = Navigasi.Detail.name) {
                TampilSiswa(

                    statusUISiswa = uiState,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}