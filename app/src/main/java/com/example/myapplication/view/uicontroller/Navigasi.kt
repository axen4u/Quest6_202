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

