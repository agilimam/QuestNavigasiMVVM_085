package com.example.pertemuan7

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.arsitektumvvm.ui.viewmodel.MahasiswaViewModel


enum class  Halaman {
    Formulir,
    Detail,
}
@Composable
fun PengelolaHalaman(
    navController: NavController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold {  }

}